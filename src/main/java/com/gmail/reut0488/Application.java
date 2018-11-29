package com.gmail.reut0488;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@EnableTransactionManagement
public class Application implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(new Class[]{Application.class}, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //Do something imiditeally after application will be start
    }
}
