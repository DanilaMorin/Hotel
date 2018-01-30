package com.netcracker.config;

/**
 * Created by 12345 on 17.01.2018.
 */
import java.util.Arrays;

import com.netcracker.services.*;
import com.netcracker.servicesImpl.ReservServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com")
public class Application {

    public static void main(String[] args) {
//        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        ReservService contactService = (ReservService) context.getBean("reservService");
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };

    }
    @Bean
    public ReservService getReservService(ReservService reservService){
        ReservService service = new ReservServiceImpl();
        return service;

    }
//

//    @Bean
//
//    public AdditServicesServie getAdditServicesServie(AdditServicesServie addServService){
//        AdditServicesServie servicesServie = new AdditServicesServieImpl();
//        return servicesServie;
//
//    }
//
//    @Bean
//    public CorpsService getCorpService(CorpsService corpsService){
//        CorpsService service = new CorpsServiceImpl();
//        return service;
//
//    }



}
