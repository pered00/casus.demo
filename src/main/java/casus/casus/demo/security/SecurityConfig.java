package casus.casus.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        auth
                .jdbcAuthentication()
                .passwordEncoder(encoder)
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, active from user_tbl where username=?")
                .authoritiesByUsernameQuery("select username, user_role from user_tbl where username=?");

//        UserDetails user =
//                User.builder()
//                        .username("user")
//                        .password(encoder.encode("user"))
//                        .roles("USER")
//                        .build();

    }




    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/public/**").hasRole("USER")
                .antMatchers("/public/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/**").permitAll()
                .anyRequest()
                .authenticated();
    }
}