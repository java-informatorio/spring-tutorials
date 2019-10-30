package com.informatorio.mvcapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {

  String[] resources = new String[]{"/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"};

  public BasicConfiguration() {
    super();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
    auth
        .inMemoryAuthentication()
        .withUser("user")
          .password(passwordEncoder().encode("password"))
          .roles("USER")
        .and()
          .withUser("admin")
          .password(passwordEncoder().encode("admin"))
        .roles("USER", "ADMIN");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers(resources).permitAll()
        .antMatchers("/login*").permitAll()
        .antMatchers("/").permitAll()
        .anyRequest().authenticated()
        .and()
          .formLogin()
          .loginPage("/login")
          .permitAll()
          .defaultSuccessUrl("/home", true)
/*          .usernameParameter("username")
          .passwordParameter("password")*/
        .and()
        .logout()
        .permitAll();
/*          .logoutUrl("/logout")
          .deleteCookies("JSESSIONID");*/
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
