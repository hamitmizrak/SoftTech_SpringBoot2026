package com.hamitmizrak.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ModelMapperBean extends AllBeanMethod {

    // Instance
    private final ModelMapper modelMapper = new ModelMapper();

    @Bean(name = "modelMapper")
    public ModelMapper modelMapperMethod() {
        // 1.YOL
        // ModelMapper data= new modelMapper();

        // 2.YOL
        // return new ModelMapper();

        //3.YOL
        return modelMapper;
    }

    @PostConstruct // Bean oluşturuludğunda çalışacak metot
    @Override
    public void onInit(){
        System.out.println("ModelMapper başladı...");
    }

    @PreDestroy // Bean yok edilmeden hemen önce çalışacak metot
    @Override
    public void onDestory(){
        System.out.println("ModelMapper bean öldü...");
    }


} // end ModelMapperBean
