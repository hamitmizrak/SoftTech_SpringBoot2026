package com.hamitmizrak.bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperBean {

    @Bean
    public ObjectMapper objectMapperBeanMethod(){
        return new ObjectMapper();
    }
} // end ObjectMapperBean
