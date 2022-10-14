package com.stussy.stussyclone20220930dohyun.config;

import com.stussy.stussyclone20220930dohyun.api.advice.AuthFailureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity //이 클래스를 활성화하겠다.
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic().disable(); //기본화면
        http.authorizeRequests() //권한에 관련된 모든 요청
                .antMatchers("/account/mypage", "/index") //이 주소로 요청이 들어오면
                .authenticated()//인가를 받아라
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .usernameParameter("email") //파라미터 변경
                .loginPage("/account/login") //로그인 페이지 Get요청
                .loginProcessingUrl("/account/login") //로그인 서비스 Post요청
                .failureHandler(new AuthFailureHandler())
                .defaultSuccessUrl("/index"); //로그인 성공하면 이 주소로 보내라

    }
}
