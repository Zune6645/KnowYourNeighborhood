package com.lithan.security;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	private UserDetailsService userDetailsService;

	private static final String[] AUTH_WHITELIST = {"/login_test", "/login", "/*" };

	//constructor
	public WebSecurityConfiguration(UserDetailsService userDetailsService) {

		this.userDetailsService = userDetailsService;

	}

	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity
				.cors().and()
				.csrf().disable()
				.authorizeRequests()
				.antMatchers(AUTH_WHITELIST).permitAll()
				.antMatchers(HttpMethod.POST, "/user/addUser").permitAll()
				.antMatchers(HttpMethod.GET, "/user/allUsers").permitAll()
				.antMatchers(HttpMethod.POST, "/login").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/*").permitAll()
				.anyRequest().authenticated()
				.and()
				.addFilter(new AuthenticationFilter(authenticationManager()))
				.addFilter(new AuthorizationFilter(authenticationManager()))
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		System.out.println("-----------------------AuthenticationManagerBuilder----------------------");
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		
		//final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		//source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		//return source;
		
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","DELETE","PUT"));
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
        

	}

}