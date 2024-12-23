package com.ty.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.ty")
public class EmployeeConfiguration {

	@Bean
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("raj").createEntityManager();
	}
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
	
	
}
