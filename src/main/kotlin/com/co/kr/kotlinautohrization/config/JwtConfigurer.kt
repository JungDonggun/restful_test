package com.co.kr.kotlinautohrization.config

import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


class JwtConfigurer(jwtTokenProvider: JwtTokenProvider) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
    private var jwtTokenProvider = JwtTokenProvider()

    fun JwtConfigurer(jwtTokenProvider: JwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider
    }

    override fun configure(http: HttpSecurity) {
        val customFilter = JwtAuthenticationFilter(jwtTokenProvider = this.jwtTokenProvider)

        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter::class.java)
    }
}
