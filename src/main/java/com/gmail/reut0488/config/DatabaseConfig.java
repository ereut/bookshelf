package com.gmail.reut0488.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    SpringLiquibase liquibase() {
       SpringLiquibase springLiquibase = new SpringLiquibase();
       springLiquibase.setDataSource(dataSource());
       springLiquibase.setChangeLog("classpath:liquibase/master-changelog.xml");
       springLiquibase.setContexts("test, production");
       return springLiquibase;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    DataSource dataSource() {
        return new DriverManagerDataSource();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.jpa")
    LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setPackagesToScan("com.gmail.reut0488.model");
        return localSessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
                = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

}
