package com.gmail.reut0488;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(new Class[]{Application.class}, args);
    }
}
