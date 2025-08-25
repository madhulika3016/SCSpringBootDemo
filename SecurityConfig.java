package com.springsecuritybasicdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
    @EnableWebSecurity
    public class SecurityConfig
  {
      @Bean
      public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
          // Configure HTTP security here
          http.authorizeHttpRequests(authorize -> authorize
                          .requestMatchers("/public/**").permitAll()
                          .anyRequest().authenticated()
                  )
                  .formLogin(form -> form.permitAll())
                  .logout(logout -> logout.permitAll());
          return http.build();
      }

      @Bean
      public WebSecurityCustomizer webSecurityCustomizer() {
          // Configure web security (ignoring requests, etc.) here
          return (web) -> web.ignoring().requestMatchers("/ignore/**");
      }
      @Bean
      public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
          UserDetails user = User.withUsername("user")
                  .password(passwordEncoder.encode("password"))
                  .roles("USER")
                  .build();

          UserDetails admin = User.withUsername("admin")
                  .password(passwordEncoder.encode("admin"))
                  .roles("USER", "ADMIN")
                  .build();

          return new InMemoryUserDetailsManager(user, admin);
      }

      @Bean
      public PasswordEncoder passwordEncoder() {

          return new BCryptPasswordEncoder();
      }



      }



