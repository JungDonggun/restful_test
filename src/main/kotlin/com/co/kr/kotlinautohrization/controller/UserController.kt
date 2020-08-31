package com.co.kr.kotlinautohrization.controller

import com.co.kr.kotlinautohrization.service.UserService
import com.co.kr.kotlinautohrization.utils.RequestEmptyValueChecker
import lombok.RequiredArgsConstructor
import org.jetbrains.annotations.NotNull
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletRequest

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
class UserController {
    private val logger: Logger = LoggerFactory.getLogger("package.ClassName")
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
