package com.javaschool.config;

import com.javaschool.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf()
                .ignoringAntMatchers("/admin/genre/**")
                .ignoringAntMatchers("/admin/orders/**")
            .and()
            .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/profile/**").hasAuthority("CUSTOMER")
                .antMatchers("/admin/**").hasAuthority("ADMIN")
            .and()
            .formLogin()
                .loginPage("/login-page")
                .usernameParameter("email")
                .loginProcessingUrl("/authenticate-user")
                .defaultSuccessUrl("/home")
                .permitAll()
            .and()
            .logout()
                .permitAll()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
            .and()
            .exceptionHandling()
                .accessDeniedPage("/access-denied");

    }

}
