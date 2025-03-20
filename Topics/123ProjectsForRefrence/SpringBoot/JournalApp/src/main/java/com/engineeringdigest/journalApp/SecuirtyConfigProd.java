package com.engineeringdigest.journalApp;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Profile("prod")
public class SecuirtyConfigProd {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	
		System.out.println("securoty ----------------proddd");
		return http.authorizeHttpRequests(request -> request.requestMatchers("/**").permitAll() // permitting all urls
																								// for demo
				/*
				 * .requestMatchers("/public/**").permitAll() .requestMatchers("/journal/**",
				 * "/user/**").authenticated() .requestMatchers("/admin/**").hasRole("ADMIN")
				 */
				.anyRequest().authenticated()).httpBasic(Customizer.withDefaults()) // every request auth
				.csrf(AbstractHttpConfigurer::disable).build();
	}

	@Bean
	AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
		return new ProviderManager(
				List.of(new org.springframework.security.authentication.dao.DaoAuthenticationProvider() {
					{
						setUserDetailsService(userDetailsService);
						setPasswordEncoder(passwordEncoder());
					}
				}));
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
