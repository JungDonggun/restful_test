package com.co.kr.kotlinautohrization.utils

import org.springframework.http.HttpStatus
import java.util.HashMap
import javax.servlet.http.HttpServletRequest


class GetAuthorizationToken {
    fun work(header: HttpServletRequest) {
        val response = HashMap<String, Any>()

        val token: String = header.getHeader("Authorization").substring(7)

        if (token === "") {
            response.put("status", HttpStatus.UNAUTHORIZED)
        }
    }
}
