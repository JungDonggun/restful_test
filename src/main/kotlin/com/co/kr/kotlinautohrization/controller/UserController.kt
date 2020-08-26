package com.co.kr.kotlinautohrization.controller

import lombok.RequiredArgsConstructor
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

import javax.servlet.http.HttpServletRequest

@RequiredArgsConstructor
@RequestMapping("/user")
open class UserController {

    @PostMapping("/register")
    fun register(header: HttpServletRequest, @NotNull @RequestBody request: Map<String, String>) {

    }


}
