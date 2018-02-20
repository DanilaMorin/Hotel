package com.netcracker.config;
//
//import io.swagger.jaxrs.config.BeanConfig;
//import io.swagger.jaxrs.listing.ApiListingResource;
//import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import javax.sql.DataSource;

/**
 * Created by 12345 on 29.01.2018.
 */

@Configuration
@ComponentScan(basePackages = "com.netcracker")
@PropertySource(value = {"classpath:application.properties"})

public class SpringConfig {
    @Autowired
    Environment environment;

    @Bean
    public DataSource dataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }
//    @Bean
//    public BeanConfig beanConfig() {
//        BeanConfig beanConfig = new BeanConfig();
//        beanConfig.setVersion("1.0.0");
//        beanConfig.setSchemes(new String[]{"http"});
//        beanConfig.setHost("localhost:8002");
//        beanConfig.setBasePath("/api");
//        beanConfig.setResourcePackage("com");
//        beanConfig.setScan(true);
//        return beanConfig;
//    }
//
//    @Bean
//    public ApiListingResource apiListingResourceJSON(){
////        Class<ApiListingResource> resource = ;
//        return new ApiListingResource();
//    }
//
//    @Bean
//    public SwaggerSerializers apiDeclarationProvider(){
////        Class<SwaggerSerializers> serializers =  SwaggerSerializers.class;
//        return new  SwaggerSerializers();
//    }


}

