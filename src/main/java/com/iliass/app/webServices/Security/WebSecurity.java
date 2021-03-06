package com.iliass.app.webServices.Security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.iliass.app.webServices.Services.UserService;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final UserService userDetailsService;
	
	
	
	public WebSecurity(BCryptPasswordEncoder bCryptPasswordEncoder, UserService userDetailsService) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		    .cors().and()
		    .csrf().disable()
		    .authorizeRequests()
		    .antMatchers(HttpMethod.POST , SecurityConstants.SIGN_UP_URL)
		    .permitAll()
		    .antMatchers("/v2/api-docs",
		    		     "/swagger-resources/**",
		    		     "/swagger-ui.html**",
		    		     "/webjars/**")
		    .permitAll()
		    .anyRequest()
		    .authenticated()
		    .and()
		    .addFilter(getAuthenticationFilter_login())
		    .addFilter(new AuthorizationFilter(authenticationManager()))
		    .sessionManagement()
		    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		       
	}
	
	// Personaliser Url for login
	
	protected AuthenticationFilter getAuthenticationFilter_login() throws Exception {
		final AuthenticationFilter  authenticationFilter = new AuthenticationFilter(authenticationManager());
		authenticationFilter.setFilterProcessesUrl("/users/login");
		return authenticationFilter; 
	}
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	

	
}
