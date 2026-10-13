package com.hamitmizrak.security.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.security.autoconfigure.web.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.util.matcher.RequestMatcher;

/*
* Basit Spring Security: JWT ve kullancıı veritabanı yoktur.
* Swagger/OpenAI : http://localhost:5555/swagger-ui/index.html
* H2-DB          : http://localhost:5555/h2-console

*
ADMIN
USERNAME:admin
PASSWORD:root

SUPER_ADMIN
USERNAME:superadmin
PASSWORD:root


localhost:5555
 */

@Configuration
@EnableMethodSecurity
public class SecurityConfig {


    @Bean
    public UserDetailsService userDetailsService(

            // ADMIN
            @Value("${app.security.admin.username}") String adminUsername,
            @Value("${app.security.admin.password}") String adminPassword,


            // SUPERADMIN
            @Value("${app.security.super-admin.username}") String superAdminUsername,
            @Value("${app.security.super-admin.password}") String superAdminPassword,
            PasswordEncoder passwordEncoder) {

        // ADMIN AND SUPERADMIN
        if (adminUsername.isBlank() || superAdminUsername.isBlank()
                || adminPassword.isBlank() || superAdminPassword.isBlank()
                || adminUsername.equals(superAdminUsername)) {
            throw new IllegalArgumentException("ADMIN and SUPER_ADMIN need distinct usernames and noempty password");
        }

        // UserDetails (ADMIN)
        UserDetails admin = User.withUsername(adminUsername)
                .password(passwordEncoder.encode(adminPassword))
                .roles("ADMIN")
                .build();

        // UserDetails (SUPER_ADMIN)
        UserDetails superAdmin = User.withUsername(superAdminUsername)
                .password(passwordEncoder.encode(superAdminPassword))
                .roles("SUPER_ADMIN","ADMIN")
                .build();

        // Database olmadan cache yapı üzerinden olsun
        return new InMemoryUserDetailsManager(admin,superAdmin);
    }

    /// ADMIN rolü SUPER_ADMIN  kullanıcıları olsun
    ///  Özel bir sayyaı sadece SUPER_ADMIN erişime sağlayabilsin

    /// ///////////////////////////////////////////////////////////////////
    /// WHITE_LIST
    private String[] whiteList() {
        return new String[]{
                "/",
                "/index",
                "/error",
                "/login",
                "/public/**",
                "/html/**",
                "/css/**",
                "/js/**",
                "/jsx/**",
                "/ts/**",
                "/images/**",
                "/webjars/**",
                "/assets/**",
                "/favicon.ico"
        };
    }

    /// ///////////////////////////////////////////////////////////////////
    // SWAGGER_UI
    private String[] swaggerWhiteList() {
        return new String[]{
                "/swagger-ui.html",
                "/swagger-ui/**",
                "/v3/api-docs",
                "/v3/api-docs/**",
        };
    }


    /// ///////////////////////////////////////////////////////////////////
    // ADMIN
    private String[] adminMatchers() {
        return new String[]{
                "/admin",
                "/admin/**",
                "/api/admin/**",
        };
    }

    /// ///////////////////////////////////////////////////////////////////
    // SUPERADMIN
    private String[] superAdminMatchers() {
        return new String[]{
                "/super-admin",
                "/super-admin/**",
                "/api/super-admin/**",
        };
    }

    /// ///////////////////////////////////////////////////////////////////
    /// FormLogin aktifken unauthenticated browser requestleri /login rediredt edebiliri ancak
    /// Swagger REST entpoint'i çağırdığımızda authentication yoksa bu redirect takip edip
    private RequestMatcher apiRequestMatcher() {
        return request -> {
            String uri = request.getRequestURI();
            if (uri == null) return false;

            return uri.startsWith("/api/")
                    || uri.startsWith("/rest/")
                    || uri.startsWith("/blog/api/")
                    || uri.startsWith("/blog/category/api/")
                    || uri.startsWith("/actuator/");
        };
    }


    /// ///////////////////////////////////////////////////////////////////
    /*
     * Swagger ve H2-Console için anonim erişim sağlansın
     * CSRF sadece H2 Console için devre dışı, diğer entpoint'lerde korunsun
     * H2-Console iframe kullanığından SAMEORIGIN gerekir.
     * */
    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity httpSecurity,
            @Value("${app.security.swagger-api-csrf-ignore:true}")
            boolean swaggerApiCsrfIgnore
    ) throws Exception {

        // H2 Console'nin gerçek yapılandırılmış yolunu eşleştirir
        RequestMatcher h2Console = PathRequest.toH2Console();

        // Swagger/API testlerinde REST entpointlerini ayırt etmek için;
        RequestMatcher apiMatcher = apiRequestMatcher();

        /*
        Swagger ile POST/PUT/DELETE/PATCH test ederken CSRF token üretmek istemeiyorsak
        Development ortamında bu matcher API'leri CSRF kontrolünden çıkarır.
        */
        RequestMatcher swaggerApiCsrfIgnoreMatcher = request -> swaggerApiCsrfIgnore && apiMatcher.matches(request);


        // httpSecurity
        httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(h2Console)
                        .permitAll()

                        .requestMatchers(swaggerWhiteList())
                        .permitAll()

                        .requestMatchers(whiteList())
                        .permitAll()

                        // Sadece Delete-All yetkisi SuperAdmin(+) verildi
                        .requestMatchers("/blog/api/v1.0.0/delete-all","/blog/category/api/v1.0.0/delete-all").hasRole("SUPER_ADMIN")

                        // CRUD write endpoints for blog and category.
                        // POST ( ADMIN(+), SUPER_ADMIN(+) )
                        .requestMatchers(org.springframework.http.HttpMethod.POST, "/blog/api/v1.0.0/**", "/blog/category/api/v1.0.0/**")
                        .hasAnyRole("ADMIN", "SUPER_ADMIN")

                        // PUT ( ADMIN(+), SUPER_ADMIN(+) )
                        .requestMatchers(org.springframework.http.HttpMethod.PUT, "/blog/api/v1.0.0/**", "/blog/category/api/v1.0.0/**")
                        .hasAnyRole("ADMIN", "SUPER_ADMIN")

                        // PATCH ( ADMIN(+), SUPER_ADMIN(+) )
                        .requestMatchers(org.springframework.http.HttpMethod.PATCH, "/blog/api/v1.0.0/**", "/blog/category/api/v1.0.0/**")
                        .hasAnyRole("ADMIN", "SUPER_ADMIN")

                        // DELETE ( ADMIN(+), SUPER_ADMIN(+) )
                        .requestMatchers(org.springframework.http.HttpMethod.DELETE, "/blog/api/v1.0.0/**", "/blog/category/api/v1.0.0/**")
                        .hasAnyRole("ADMIN", "SUPER_ADMIN")

                        // Sadece SUPER_ADMIN giriş yapabilir.
                        .requestMatchers(superAdminMatchers())
                        .hasRole("SUPER_ADMIN")

                        //  SUPER_ADMIN ve ADMIN  giriş yapabilir.
                        .requestMatchers(adminMatchers())
                        .hasAnyRole("ADMIN", "SUPER_ADMIN")

                        .anyRequest()
                        .authenticated()
                )

                // H2 Console POST işlemlerinde CSRF istisnasını
                .csrf(csrf -> csrf.ignoringRequestMatchers(
                                h2Console,
                                swaggerApiCsrfIgnoreMatcher
                        )
                )

                // H2 Console ifram kullanılır
                .headers(headers -> headers
                        .frameOptions(frame -> frame.sameOrigin())
                )

                .formLogin(Customizer.withDefaults())

                /*
                HTTP Basic: Swagger UI içindeki butonu Basic Auth bilgileri API request'lerine Authorization header oalrak gönderebilir.
                Header Örneği:
                Authorization: Basic xxxxxxx
                 */
                .httpBasic(Customizer.withDefaults())

                // API'DE Login Html Yerine 401 Swagger
                .exceptionHandling(exception -> exception.defaultAuthenticationEntryPointFor(
                                new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED), apiMatcher
                        )
                )

                .logout(Customizer.withDefaults());

        return httpSecurity.build();
    }


} // end UserDetailsService
