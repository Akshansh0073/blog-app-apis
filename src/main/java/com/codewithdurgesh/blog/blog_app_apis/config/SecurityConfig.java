package com.codewithdurgesh.blog.blog_app_apis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.codewithdurgesh.blog.blog_app_apis.security.CustomUserDetailService;
import com.codewithdurgesh.blog.blog_app_apis.security.JwtAuthenticationEntryPoint;
import com.codewithdurgesh.blog.blog_app_apis.security.JwtAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private JwtAuthenticationEntryPoint point;
	
	@Autowired
	private JwtAuthenticationFilter filter;
	
		@Bean 
		SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
			http
			.csrf(csrf -> csrf.disable())
			.cors(cors -> cors.disable())
			.authorizeHttpRequests(auth -> 
					auth.requestMatchers("/api/v1/auth/**").permitAll()
//						.requestMatchers(HttpMethod.GET).permitAll()
							     .anyRequest().authenticated())
			.exceptionHandling(ex -> ex.authenticationEntryPoint(point))
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
			
			http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
			return http.build();
		}
		
//		@Bean
//		public UserDetailsService userDetailsService() {
//			UserDetails admin = User.withUsername("akshansh").password("{noop}password").roles("Admin").build();
//			UserDetails user = User.withUsername("divyansh").password("{noop}password").roles("User").build();
//			
//			return new InMemoryUserDetailsManager(admin,user);
//		}

//		@Bean
//		public UserDetailsService userDetailsService(DataSource dataSource) {
//			UserDetails admin = User.withUsername("akshansh")
//					.password("dummy").passwordEncoder(str -> passwordEncoder().encode(str))
//					.roles("Admin","User")
//					.build();
//			UserDetails user = User.withUsername("divyansh")
//					.password("dummy").passwordEncoder(str -> passwordEncoder().encode(str))
//					.roles("User").build();
//			
//			JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//			jdbcUserDetailsManager.createUser(user);
//			jdbcUserDetailsManager.createUser(admin);
//			return jdbcUserDetailsManager;
//		}
//		
//
//		@Bean
//		public DataSource dataSource() {
//			return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
//					.addScript(org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
//					.build();
//		}
//		
		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
		
	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
	        return builder.getAuthenticationManager();
	    }
		
		
		@Bean
		public DaoAuthenticationProvider daoAuthenticationProvider() {
			DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
			provider.setUserDetailsService(customUserDetailService);
			provider.setPasswordEncoder(passwordEncoder());
			return provider;
		}

		
}
