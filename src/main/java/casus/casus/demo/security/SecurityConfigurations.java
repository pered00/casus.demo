package casus.casus.demo.security;

import casus.casus.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authenticationService).passwordEncoder(new BCryptPasswordEncoder());
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/auth").permitAll()
				.antMatchers(HttpMethod.POST, "/document").permitAll()
				.antMatchers(HttpMethod.GET,"/document,**").hasRole("Super")
				.antMatchers(HttpMethod.PUT,"/document,**").hasRole("Super")
				.antMatchers(HttpMethod.DELETE,"/document,**").hasRole("Super")
				.antMatchers(HttpMethod.POST,"/role,**").hasRole("Super")
				.antMatchers(HttpMethod.GET,"/role,**").hasRole("Super")
				.antMatchers(HttpMethod.PUT,"/role,**").hasRole("Super")
				.antMatchers(HttpMethod.DELETE,"/role,**").hasRole("Super")
				.antMatchers(HttpMethod.POST,"/user,**").hasRole("Super")
				.antMatchers(HttpMethod.GET,"/user,**").hasRole("Super")
				.antMatchers(HttpMethod.PUT,"/user,**").hasRole("Super")
				.antMatchers(HttpMethod.DELETE,"/user,**").hasRole("Super")
				.antMatchers(HttpMethod.POST,"/service,**").hasRole("Super")
				.antMatchers(HttpMethod.GET,"/service,**").hasRole("Super")
				.antMatchers(HttpMethod.PUT,"/service,**").hasRole("Super")
				.antMatchers(HttpMethod.DELETE,"/service,**").hasRole("Super")
				.antMatchers(HttpMethod.POST,"/order,**").hasRole("Super")
				.antMatchers(HttpMethod.GET,"/order,**").hasRole("Super")
				.antMatchers(HttpMethod.PUT,"/order,**").hasRole("Super")
				.antMatchers(HttpMethod.DELETE,"/order,**").hasRole("Super")
				.antMatchers(HttpMethod.POST,"/part,**").hasRole("Super")
				.antMatchers(HttpMethod.GET,"/part,**").hasRole("Super")
				.antMatchers(HttpMethod.PUT,"/part,**").hasRole("Super")
				.antMatchers(HttpMethod.DELETE,"/part,**").hasRole("Super")
				.antMatchers(HttpMethod.POST,"/customer,**").hasRole("Super")
				.antMatchers(HttpMethod.GET,"/customer,**").hasRole("Super")
				.antMatchers(HttpMethod.PUT,"/customer,**").hasRole("Super")
				.antMatchers(HttpMethod.DELETE,"/customer,**").hasRole("Super")
				.antMatchers(HttpMethod.POST,"/vehicle,**").hasRole("Super")
				.antMatchers(HttpMethod.GET,"/vehicle,**").hasRole("Super")
				.antMatchers(HttpMethod.PUT,"/vehicle,**").hasRole("Super")
				.antMatchers(HttpMethod.DELETE,"/vehicle,**").hasRole("Super")
				.antMatchers(HttpMethod.POST,"/vehicle,**").hasRole("AdmAssistant")
				.antMatchers(HttpMethod.GET,"/vehicle,**").hasRole("AdmAssistant")
				.antMatchers(HttpMethod.PUT,"/vehicle,**").hasRole("AdmAssistant")
				.antMatchers(HttpMethod.GET,"/document,**").hasRole("AdmAssistant")
				.antMatchers(HttpMethod.PUT,"/document,**").hasRole("AdmAssistant")
				.antMatchers(HttpMethod.DELETE,"/document,**").hasRole("AdmAssistant")
				.antMatchers(HttpMethod.POST,"/order,**").hasRole("AdmAssistant")
				.antMatchers(HttpMethod.GET,"/order,**").hasRole("AdmAssistant")
				.antMatchers(HttpMethod.PUT,"/order,**").hasRole("AdmAssistant")
				.antMatchers(HttpMethod.DELETE,"/order,**").hasRole("AdmAssistant")
				.antMatchers(HttpMethod.POST,"/customer,**").hasRole("AdmAssistant")
				.antMatchers(HttpMethod.GET,"/customer,**").hasRole("AdmAssistant")
				.antMatchers(HttpMethod.PUT,"/customer,**").hasRole("AdmAssistant")
				.antMatchers(HttpMethod.GET,"/service,**").hasRole("Mechanic")
				.antMatchers(HttpMethod.GET,"/order,**").hasRole("Mechanic")
				.antMatchers(HttpMethod.PUT,"/order,**").hasRole("Mechanic")
				.antMatchers(HttpMethod.GET,"/part,**").hasRole("Mechanic")
				.antMatchers(HttpMethod.GET,"/service,**").hasRole("Frontdesk")
				.antMatchers(HttpMethod.GET,"/order,**").hasRole("Frontdesk")
				.antMatchers(HttpMethod.PUT,"/order,**").hasRole("Frontdesk")
				.antMatchers(HttpMethod.GET,"/part,**").hasRole("Frontdesk")
				.antMatchers(HttpMethod.POST,"/service,**").hasRole("BackOffice")
				.antMatchers(HttpMethod.GET,"/service,**").hasRole("BackOffice")
				.antMatchers(HttpMethod.PUT,"/service,**").hasRole("BackOffice")
				.antMatchers(HttpMethod.DELETE,"/service,**").hasRole("BackOffice")
				.antMatchers(HttpMethod.POST,"/part,**").hasRole("BackOffice")
				.antMatchers(HttpMethod.GET,"/part,**").hasRole("BackOffice")
				.antMatchers(HttpMethod.PUT,"/part,**").hasRole("BackOffice")
				.antMatchers(HttpMethod.DELETE,"/part,**").hasRole("BackOffice")
				.anyRequest().authenticated()
		.and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(new AuthenticationByTokenFilter(tokenService, userRepository), UsernamePasswordAuthenticationFilter.class);
	}
	

	
}







