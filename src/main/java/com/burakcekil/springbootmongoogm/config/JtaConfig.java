package com.burakcekil.springbootmongoogm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;

/**
 * Summary
 * <p>
 * Description
 *
 * @author Burak Cekil (burakcekil.com)
 * @version 1.0
 * @since 4/18/2020
 */

@Configuration
public class JtaConfig {

    @Bean
    public EntityManagerFactory entityManagerFactory() {

        return Persistence.createEntityManagerFactory("ogm-petshop");
    }

    @Bean
    public TransactionManager transactionManager() {
        return com.arjuna.ats.jta.TransactionManager.transactionManager();
    }
}
