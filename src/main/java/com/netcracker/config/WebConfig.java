package com.netcracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * Created by 12345 on 22.02.2018.
 */
@Configuration
//@EnableWebMvc
@ComponentScan({ "com" })
//@Import({ AppSecurityConfig.class })


public class WebConfig {
        //extends WebMvcConfigurerAdapter {
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
//        registry.addViewController("/").setViewName("index");
//    }



    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        //viewResolver.setViewClass(InternalResourceViewResolver.class);

        viewResolver.setPrefix("/");
       // viewResolver.setSuffix(".jsp");
         viewResolver.setSuffix(".html");
        return viewResolver;
        //WEB-INF/views/ WEB-INF/views/login.jsp
    }
    @Bean
    public ServletContextTemplateResolver templateResolver(){
        ServletContextTemplateResolver servletContextTemplateResolver = new ServletContextTemplateResolver();
        servletContextTemplateResolver.setPrefix("/");
        servletContextTemplateResolver.setSuffix(".html");
        //servletContextTemplateResolver.setSuffix(".jsp");
        servletContextTemplateResolver.setTemplateMode("HTML5");
        //servletContextTemplateResolver.setCacheable(false);
        return servletContextTemplateResolver;
    }
}