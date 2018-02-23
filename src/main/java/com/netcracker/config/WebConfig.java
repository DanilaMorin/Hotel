package com.netcracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by 12345 on 22.02.2018.
 */
@Configuration
//@EnableWebMvc
@ComponentScan({ "com" })
//@Import({ AppSecurityConfig.class })
public class WebConfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/");
        //viewResolver.setSuffix(".jsp");
        viewResolver.setSuffix(".html");
        return viewResolver;
        //WEB-INF/views/ WEB-INF/views/helloworld.jsp
    }
}