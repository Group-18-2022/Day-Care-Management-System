/*
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
                .roles(Role.PRINCIPAL.name())
                .and()
                .withUser("Teacher")
                .password(encoder().encode("{noop}123456"))
                .roles(Role.TEACHER.name())
                .and()
                .withUser("Principal")
                .password(encoder().encode("{noop}123456"))
                .roles(Role.PRINCIPAL.name())
                .and()
                .withUser("Secretary")
                .password(encoder().encode("{noop}123456"))
                .roles(Role.SECRETARY.name());;
    }
//TODO: Add Driver & VehicleRegDetails routes
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeHttpRequests()
                //Role: TEACHER
                .antMatchers(HttpMethod.GET, "api/v1/day-care/parent/").hasRole(Role.TEACHER.name())

                .antMatchers(HttpMethod.GET, "api/v1/day-care/child/").hasRole(Role.TEACHER.name())

                .antMatchers(HttpMethod.GET, "api/v1/day-care/parent-child/").hasRole(Role.TEACHER.name())

                .antMatchers(HttpMethod.GET, "api/v1/day-care/doctor/").hasRole(Role.TEACHER.name())

                .antMatchers(HttpMethod.GET, "api/v1/day-care/parent-doctor/").hasRole(Role.TEACHER.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/incidents/").hasRole(Role.TEACHER.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/incidents/").hasRole(Role.TEACHER.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/incidents/").hasRole(Role.TEACHER.name())
//                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/incidents/").hasRole(Role.TEACHER.name())

                .antMatchers(HttpMethod.GET, "api/v1/day-care/teacher/").hasRole(Role.TEACHER.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/teacher/").hasRole(Role.TEACHER.name())

                .antMatchers(HttpMethod.GET, "api/v1/day-care/teacher-class/").hasRole(Role.TEACHER.name())

                .antMatchers(HttpMethod.GET, "api/v1/day-care/group-room/").hasRole(Role.TEACHER.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/esp/").hasRole(Role.TEACHER.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/esp/").hasRole(Role.TEACHER.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/esp/").hasRole(Role.TEACHER.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/classregister/").hasRole(Role.TEACHER.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/classregister/").hasRole(Role.TEACHER.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/classregister/").hasRole(Role.TEACHER.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/classgroup/").hasRole(Role.TEACHER.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/classgroup/").hasRole(Role.TEACHER.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/classgroup/").hasRole(Role.TEACHER.name())

                .antMatchers(HttpMethod.GET, "api/v1/day-care/venue/").hasRole(Role.TEACHER.name())

                .antMatchers(HttpMethod.GET, "api/v1/day-care/classroom/").hasRole(Role.TEACHER.name())

                //Role: PRINCIPAL
                .antMatchers(HttpMethod.POST, "api/v1/day-care/parent/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/parent/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/parent/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/parent/").hasRole(Role.PRINCIPAL.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/child/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/child/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/child/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/child/").hasRole(Role.PRINCIPAL.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/parent-child/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/parent-child/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/parent-child/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/parent-child/").hasRole(Role.PRINCIPAL.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/doctor/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/doctor/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/doctor/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/doctor/").hasRole(Role.PRINCIPAL.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/parent-doctor/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/parent-doctor/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/parent-doctor/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/parent-doctor/").hasRole(Role.PRINCIPAL.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/incidents/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/incidents/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/incidents/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/incidents/").hasRole(Role.PRINCIPAL.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/teacher/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/teacher/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/teacher/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/teacher/").hasRole(Role.PRINCIPAL.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/teacher-class/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/teacher-class/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/teacher-class/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/teacher-class/").hasRole(Role.PRINCIPAL.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/group-room/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/group-room/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/group-room/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/group-room/").hasRole(Role.PRINCIPAL.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/esp/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/esp/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/esp/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/esp/").hasRole(Role.PRINCIPAL.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/classregister/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/classregister/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/classregister/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/classregister/").hasRole(Role.PRINCIPAL.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/classgroup/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/classgroup/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/classgroup/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/classgroup/").hasRole(Role.PRINCIPAL.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/venue/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/venue/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/venue/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/venue/").hasRole(Role.PRINCIPAL.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/classroom/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/classroom/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/classroom/").hasRole(Role.PRINCIPAL.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/classroom/").hasRole(Role.PRINCIPAL.name())

                //Role: Secretary
                .antMatchers(HttpMethod.POST, "api/v1/day-care/parent/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/parent/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/parent/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/parent/").hasRole(Role.SECRETARY.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/child/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/child/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/child/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/child/").hasRole(Role.SECRETARY.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/parent-child/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/parent-child/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/parent-child/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/parent-child/").hasRole(Role.SECRETARY.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/doctor/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/doctor/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/doctor/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/doctor/").hasRole(Role.SECRETARY.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/parent-doctor/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/parent-doctor/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/parent-doctor/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/parent-doctor/").hasRole(Role.SECRETARY.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/incidents/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/incidents/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/incidents/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/incidents/").hasRole(Role.SECRETARY.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/teacher/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/teacher/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/teacher/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/teacher/").hasRole(Role.SECRETARY.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/teacher-class/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/teacher-class/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/teacher-class/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/teacher-class/").hasRole(Role.SECRETARY.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/group-room/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/group-room/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/group-room/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/group-room/").hasRole(Role.SECRETARY.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/esp/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/esp/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/esp/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/esp/").hasRole(Role.SECRETARY.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/classregister/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/classregister/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/classregister/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/classregister/").hasRole(Role.SECRETARY.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/classgroup/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/classgroup/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/classgroup/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/classgroup/").hasRole(Role.SECRETARY.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/venue/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/venue/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/venue/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/venue/").hasRole(Role.SECRETARY.name())

                .antMatchers(HttpMethod.POST, "api/v1/day-care/classroom/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.GET, "api/v1/day-care/classroom/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.PUT, "api/v1/day-care/classroom/").hasRole(Role.SECRETARY.name())
                .antMatchers(HttpMethod.DELETE, "api/v1/day-care/classroom/").hasRole(Role.SECRETARY.name())

                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
 */