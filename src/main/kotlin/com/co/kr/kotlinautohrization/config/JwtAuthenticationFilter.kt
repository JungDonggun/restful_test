package com.co.kr.kotlinautohrization.config

import org.springframework.web.filter.GenericFilterBean
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

class JwtAuthenticationFilter(jwtTokenProvider: JwtTokenProvider) : GenericFilterBean() {
    private var jwtTokenProvider: JwtTokenProvider = JwtTokenProvider()

    fun JwtAuthenticationFilter(jwtTokenProvider: JwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider
    }

    override fun doFilter(request: ServletRequest, response: ServletResponse, filterChain: FilterChain) {
        val token = jwtTokenProvider.resolveToken(request as HttpServletRequest)

        if (token != null && jwtTokenProvider.validateToken(token)) {
//            val auth: Authentication = jwtTokenProvider.
//            SecurityContextHolder.getContext().authentication = auth
//            println("SecurityContextHolder : " + SecurityContextHolder.getContext().toString())
        }

        filterChain.doFilter(request, response)
    }
}
