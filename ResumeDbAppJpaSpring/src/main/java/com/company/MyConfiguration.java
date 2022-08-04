package com.company;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
//@Scope("prototype")
public class MyConfiguration {

//    @Bean(name = "obj")
//    @Scope("prototype")
//    Object getObject() {
//        System.out.println("Salam, obyekti yaratdım.");
//        return new Object();
//    }
    @Bean
    public void test() {
        System.out.println("test");
    }
}
