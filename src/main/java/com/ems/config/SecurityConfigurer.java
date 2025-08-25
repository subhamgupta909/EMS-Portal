package com.ems.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer {
	@Autowired
	private CustomerUserDetailsService customerUserDetailsService;
	
	@Autowired
	private CustomSuccessHandler customSuccessHandler;

	@Bean
	public HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
		return new HandlerMappingIntrospector();
	}

	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests((req) -> req.requestMatchers("/login").permitAll().requestMatchers("/admin/**")
						.hasRole("ADMIN").requestMatchers("/client/**").hasRole("CLIENT")
						.requestMatchers("/employee/**").hasRole("EMPLOYEE").anyRequest().authenticated())
				.formLogin(form -> form

						.loginPage("/login").loginProcessingUrl("/doLogin").successHandler(customSuccessHandler)
						.failureUrl("/login?error=true").permitAll())
				.logout(logout -> logout
				        .logoutUrl("/logout")   
				        .logoutSuccessUrl("/login?logout=true")
				        .invalidateHttpSession(true)
				        .clearAuthentication(true)
				        .permitAll()

						);

		return http.build();

	}

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder encoder) throws Exception {

		return http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(customerUserDetailsService)
				.passwordEncoder(encoder).and().build();
	}
}
