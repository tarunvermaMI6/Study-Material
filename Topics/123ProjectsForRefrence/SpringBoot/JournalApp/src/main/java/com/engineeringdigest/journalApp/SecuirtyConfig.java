package com.engineeringdigest.journalApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.engineeringdigest.journalApp.service.JwtFilter;

@Configuration
@EnableWebSecurity
@Profile("dev")
public class SecuirtyConfig {

   @Autowired
   JwtFilter jwtFilter;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		System.out.println("securoty ----------------");
		
		return http.authorizeHttpRequests(request -> 
		// "/public/**",
		request
		 .requestMatchers("/journal/**","/user/**","/external/**").permitAll() 
		 .requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated())
				//.httpBasic(Customizer.withDefaults()) // removing basic auth
				.csrf(AbstractHttpConfigurer::disable)
		.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
		.build();
		 
		
	}
/*  // removing basic auth
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
  */
	
	@Bean
     AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception {
        return auth.getAuthenticationManager();
    }
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
