package za.ac.cput.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Test User")
                .password("{noop}123456")
                .roles("ADMIN")
                .and()
                .withUser("Parent")
                .password(encoder().encode("123456"))
                .roles("PARENT")
                .and()
                .withUser("Doctor")
                .password(encoder().encode("123456"))
                .roles("DOCTOR");
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.POST, "api/v1/day-care/parent/").hasRole("PARENT")
                .antMatchers(HttpMethod.GET, "api/v1/day-care/parent/").hasRole("PARENT")
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/parent/").hasRole("PARENT")
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/parent/").hasRole("PARENT")
                .antMatchers(HttpMethod.POST, "api/v1/day-care/doctor/").hasRole("DOCTOR")
                .antMatchers(HttpMethod.GET, "api/v1/day-care/doctor/").hasRole("DOCTOR")
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/doctor/").hasRole("DOCTOR")
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/doctor/").hasRole("DOCTOR")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
