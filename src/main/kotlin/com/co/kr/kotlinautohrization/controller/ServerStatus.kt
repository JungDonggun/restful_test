package com.co.kr.kotlinautohrization.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/server")
class ServerStatus {
    @GetMapping("/state")
    fun serverStatus(): ResponseEntity<Any> {
        return ResponseEntity(HttpStatus.OK)
    }
}
