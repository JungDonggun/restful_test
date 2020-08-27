package com.co.kr.kotlinautohrization.service

import lombok.RequiredArgsConstructor
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.RequestBody

@RequiredArgsConstructor
open class UserService {

    fun register(@NotNull @RequestBody request: Map<String, String>) {
        
    }
}
