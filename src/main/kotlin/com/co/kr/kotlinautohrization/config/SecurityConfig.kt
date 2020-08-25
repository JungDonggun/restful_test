package com.co.kr.kotlinautohrization.config

import lombok.RequiredArgsConstructor
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer
import org.springframework.security.config.http.SessionCreationPolicy


@Configuration // -> 해당 클래스는 Spring 설정과 관련된 파일이다 라는 것을 알려줌
@RequiredArgsConstructor
@EnableWebSecurity // -> 웹 보안을  활성화 시킴 하지만 그자체로는 유용 하지 않고 스프링 시큐리티가 WebSecurityConfigurer를 구현하거나 컨텍스트의 WebSebSecurityConfigurerAdapter를 확장한 빈으로 설정되어 있어야 한다.
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true) // -> 어노테이션 기반 보안을 적용할 수 있습니다
class SecurityConfig : WebSecurityConfigurerAdapter() {


    @Override
    protected fun configure(http: HttpSecurity) {
        http
                .httpBasic().and()
                .formLogin().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/server/state").permitAll()
                .antMatchers("/user/register").anonymous()
                .antMatchers("/user/login").anonymous()
                .anyRequest().authenticated()
                .and()
//                .apply(OAuth2ResourceServerConfigurer.JwtConfigurer)
    }

}
