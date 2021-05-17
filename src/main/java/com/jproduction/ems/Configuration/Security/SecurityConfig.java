package com.jproduction.ems.Configuration.Security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		
		return provider;
	}

//	// redirect to instsant message page for testing
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// the boolean flags force the redirection even though
//		// the user requested a specific secured resource.
//		http.formLogin().defaultSuccessUrl("/index.html", true);
//	}

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService);
//	}
	
//	@Override
//	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//		// authentication manger (see below)
//		
//		
//		
//		
//		// When full persistence is not yet necessary:
//		 auth.inMemoryAuthentication()
//	        .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
//	        .and()
//	        .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
//	        .and()
//	        .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
//	}
//	
//	@Bean
//	private Object passwordEncoder() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	protected void configure(final HttpSecurity http) throws Exception {
//		// http builder configurations for authorize requests and form login (see below)
//	}
	

	
//	Deprecated approach
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		
//		List<UserDetails> users = new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder().username("jacky").password("password123").roles("USER").build());
//		
//		return new InMemoryUserDetailsManager(users);
//		
//	}
	
	
}
