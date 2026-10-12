package com.hamitmizrak.security.config;

/*
* Basit Spring Security: JWT ve kullancıı veritabanı yoktur.
* Swagger/OpenAI : http://localhost:5555/swagger-ui/index.html
* H2-DB          : http://localhost:5555/h2-console
* */

/*
USERNAME:hamitmizrak@gmail.com
PASSWORD:root

localhost:5555
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.security.autoconfigure.web.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
public class SecurityConfig {

    /*@Value("${app.security.username}")
    String username;

    @Value("${app.security.password}")
    String password;*/

    /*
    application.properties => ortam değişkeninin ADMIN bilgileri oluştur
    app.security.username=${APP_SECURITY_USERNAME:hamitmizrak@gmail.com}
    app.security.password=${APP_SECURITY_PASSWORD:root}
     */
    @Bean
    public UserDetailsService userDetailsService(
            @Value("${app.security.username:hamitmizrak@gmail.com}")
            String username,

            @Value("${app.security.password:root}")
            String password,

            PasswordEncoder passwordEncoder) {
            UserDetails userDetails = User.withUsername(username)
                .password(passwordEncoder.encode(password))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }

    /// ADMIN rolü SUPER_ADMIN  kullanıcıları olsun
    ///  Özel bir sayyaı sadece SUPER_ADMIN erişime sağlayabilsin

    /// ///////////////////////////////////////////////////////////////////
    private String[] whiteList(){
        return new String[]{
                "/",
                "/index",
                "/error",
                "/login",
                "/public/**",
                "/swagger-ui.html",
                "/swagger-ui/**",
                "/v3/api-docs/**",
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
    // Swagger izin


    /// ///////////////////////////////////////////////////////////////////

    /*
     * Swagger ve H2-Console için anonim erişim sağlansın
     * CSRF sadece H2 Console için devre dışı, diğer entpoint'lerde korunsun
     * H2-Console iframe kullanığından SAMEORIGIN gerekir.
     * */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        // H2 Console'nin gerçek yapılandırılmış yolunu eşleştirir
        RequestMatcher h2Console = PathRequest.toH2Console();

        // httpSecurity
        httpSecurity
                .authorizeHttpRequests(auth-> auth.requestMatchers(h2Console).permitAll()
                        .requestMatchers(whiteList()).permitAll()
                        .anyRequest().authenticated()
                )

                // H2 Console POST işlemlerinde CSRF istisnasını
                .csrf(csrf -> csrf.ignoringRequestMatchers(h2Console)
                )

                // H2 Console ifram kullanılır
                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin())
                )

                .formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults());

        return httpSecurity.build();
    }


} // end UserDetailsService
