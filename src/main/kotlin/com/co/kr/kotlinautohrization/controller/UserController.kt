package com.co.kr.kotlinautohrization.controller

import com.co.kr.kotlinautohrization.service.UserService
import com.co.kr.kotlinautohrization.utils.RequestEmptyValueChecker
import lombok.RequiredArgsConstructor
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

import javax.servlet.http.HttpServletRequest

@RequiredArgsConstructor
@RequestMapping("/user")
open class UserController {
    private val userService: UserService = UserService()
    private val requestEmptyValueChecker: RequestEmptyValueChecker = RequestEmptyValueChecker()

    @PostMapping("/register")
    fun register(header: HttpServletRequest, @NotNull @RequestBody request: Map<String, String>) {
        val checkList: Array<String> = arrayOf("identity", "password", "name", "homeTown")

        if (requestEmptyValueChecker.check(request, checkList)) {
            return userService.register(request)
        } else {
            // return status 400 error
        }
    }
}
