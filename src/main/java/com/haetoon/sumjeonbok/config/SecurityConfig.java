package com.haetoon.sumjeonbok.config;

import com.haetoon.sumjeonbok.service.login.handler.CustomLoginFailureHandler;
import com.haetoon.sumjeonbok.service.login.handler.CustomLoginSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomLoginFailureHandler customLoginFailureHandler;
    private final CustomLoginSuccessHandler customLoginSuccessHandler;

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web -> web.ignoring().requestMatchers(
                "/css/**","/js/**","/**"
        ));
    }

   @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((auth)->auth
                .requestMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated()
        );
//        httpSecurity.formLogin((auth)->auth
//                .loginPage("/login")
//                .loginProcessingUrl("/loginProcess")
//                .usernameParameter("userId")
//                .passwordParameter("userPw")
//                .successHandler(customLoginSuccessHandler)
//                .failureHandler(customLoginFailureHandler)
//                .permitAll()
//        );

        return httpSecurity.build();
   }
}
