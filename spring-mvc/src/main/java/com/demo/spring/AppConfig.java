package com.demo.spring;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.demo")
@EnableTransactionManagement
public class AppConfig {
	
/*	@Bean
	public DriverManagerDataSource dataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springdb");
		ds.setUsername("root");
		ds.setPassword("admin");
		return ds;
	}
*/
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
		LocalContainerEntityManagerFactoryBean lcemfb= new LocalContainerEntityManagerFactoryBean();
		lcemfb.setDataSource(dataSource);
		HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
		hjva.setDatabase(Database.MYSQL);
		hjva.setShowSql(true);
		lcemfb.setPackagesToScan("com.demo.entity");
		lcemfb.setJpaVendorAdapter(hjva);
		return lcemfb;
	}
	
	@Bean
	public JpaTransactionManager tranactionManager(EntityManagerFactory entityManagerFactory){
		JpaTransactionManager jtm = new JpaTransactionManager();
		jtm.setEntityManagerFactory(entityManagerFactory);
		return jtm;
	}
}
