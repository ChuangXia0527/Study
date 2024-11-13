package com.itheima.medicinesystem.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)  // 关闭 CSRF 保护
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/register", "/user/login").permitAll()  // 允许访问注册和登录接口
                        //.anyRequest().authenticated()  // 其他所有请求都需要认证
                        .anyRequest().permitAll()//所有请求都放行
                );

        return http.build();
    }


    @Bean
    public com.itheima.medicinesystem.common.JwtInterceptor jwtInterceptor() {
        return new com.itheima.medicinesystem.common.JwtInterceptor();
    }

}
