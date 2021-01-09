package com.java;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 @Autowired
	private DataSource datasource;
 
 //to access data from managertable
@Autowired
 public void configAuthntication(AuthenticationManagerBuilder authbuild) throws Exception{
	 authbuild.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
     .dataSource(datasource)
     .usersByUsernameQuery("select username, password, enabled from users where username=?")
     .authoritiesByUsernameQuery("select username, role from users where username=?")
 ;
 }
 //login authentication
@Override
protected void configure(HttpSecurity http) throws Exception {
	 http.authorizeRequests()
     .anyRequest().authenticated()
     .and()
     .formLogin().permitAll()
     .and()
     .logout().permitAll();
}
	
}
