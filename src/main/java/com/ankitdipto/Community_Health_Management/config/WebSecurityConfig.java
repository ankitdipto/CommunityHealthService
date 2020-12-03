package com.ankitdipto.Community_Health_Management.config;



import com.ankitdipto.Community_Health_Management.USER.UserDetailsServiceImpl;

//import com.ankitdipto.Community_Health_Management.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
	private UserDetailsServiceImpl userService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {

		return new BCryptPasswordEncoder();
	}


	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {

		    http
				.authorizeRequests()
				.antMatchers("/sign-up/**", "/sign-in/**")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/sign-in")
				.permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService)
				.passwordEncoder(bCryptPasswordEncoder());
	}*/

	@Override
        protected void configure(HttpSecurity http) throws Exception {
			http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/**","/sign-up","/images/skyImageBg.jpg").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.permitAll()
				.defaultSuccessUrl("/",true)
				.failureUrl("/sign-in?error=true")
				.and()
			.logout()
				.permitAll();
		}

        @Autowired
        protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
				//auth.inMemoryAuthentication().withUser("user").password(bCryptPasswordEncoder().encode("password")).roles("USER");
				auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
		}
		
		
}
