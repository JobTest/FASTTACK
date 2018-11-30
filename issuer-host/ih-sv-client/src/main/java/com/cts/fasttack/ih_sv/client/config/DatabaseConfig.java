package com.cts.fasttack.ih_sv.client.config;

import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

/**
 * @author d.ishchenko
 */
@Configuration
@EntityScan("com.cts.fasttack")
public class DatabaseConfig {

	@Bean
	public SessionFactory sessionFactory(EntityManagerFactory emf) {
		return emf.unwrap(SessionFactory.class);
	}

}
