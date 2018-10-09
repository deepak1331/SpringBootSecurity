package com.deepakEdu.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

//import com.deepakEdu.filter.CustomFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// We have to use {noop} along with password to
//		auth.inMemoryAuthentication().withUser("deepak").password("{noop}admin@123").roles("ADMIN").and()
//				.withUser("guest").password("{noop}password").roles("USER");

		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("deepak")
				.password("admin@123").roles("ADMIN").and().withUser("guest").password("password").roles("USER");
	}

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		System.out.println("Inside Spring Security configure");
		// permits all requests without any authentication
//		httpSecurity.authorizeRequests().anyRequest().permitAll().and().httpBasic();

		// authenticate each and every requests
//		httpSecurity.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();

		// for all the GET requests having role as ADMIN
		httpSecurity.authorizeRequests().antMatchers(HttpMethod.GET).hasRole("ADMIN").and().httpBasic();
//		httpSecurity.authorizeRequests().antMatchers(HttpMethod.GET, "*/bye/").hasAnyRole("USER","ADMIN").and().httpBasic();

		// Using Filters
//		httpSecurity.authorizeRequests().anyRequest().fullyAuthenticated().and().addFilterBefore(customFilter(), BasicAuthenticationFilter.class).httpBasic();
//		httpSecurity.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
//		httpSecurity.csrf().disable();
	}

//	@Bean
//	public CustomFilter customFilter() {
//
//		return new CustomFilter();
//	}
}
