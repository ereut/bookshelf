package com.gmail.reut0488;

import com.gmail.reut0488.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{Application.class, ApplicationConfig.class}, args);

    }

}
