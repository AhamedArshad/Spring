package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public DriverManagerDataSource dataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springdb");
		ds.setUsername("root");
		ds.setPassword("admin");
		return ds;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http
	.csrf()
	.disable()
	.authorizeRequests()
	.antMatchers("/**")
	.hasRole("USER")
	.and()
	.httpBasic();
	}
	
	
	//this is not predefined method , this is user defined method
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
	
		/*	auth.inMemoryAuthentication()
		.withUser("scott")
		.password("welcome1")
		.roles("USER");
		
		auth.inMemoryAuthentication()
		.withUser("arun")
		.password("welcome1")
		.roles("ADMIN");
		
		auth.inMemoryAuthentication()
		.withUser("pavan")
		.password("welcome1")
		.disabled(true)
		.roles("USER");*/
		
		
		auth
		.jdbcAuthentication()
		.dataSource(dataSource())
		.usersByUsernameQuery("select username,password,enabled from users where username=?")
		.authoritiesByUsernameQuery("select username,authority from authorities where username=?");
	}

}
