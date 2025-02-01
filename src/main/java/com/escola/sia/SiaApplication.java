package com.escola.sia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class SiaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SiaApplication.class, args);
    }
    // Essa parte habilita o JSP mas desabilita o Thymeleaf
    // @Bean
    // public InternalResourceViewResolver defaultViewResolver() {
    // InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    // resolver.setPrefix("/WEB-INF/views/");
    // resolver.setSuffix(".jsp");
    // resolver.setOrder(0); // Define uma ordem baixa para priorizar este
    // resolvedor
    // return resolver;
    // }
}
