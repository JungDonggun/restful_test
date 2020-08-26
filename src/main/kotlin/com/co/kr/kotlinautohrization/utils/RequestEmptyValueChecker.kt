package com.co.kr.kotlinautohrization.utils

import lombok.RequiredArgsConstructor
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.RequestBody

@RequiredArgsConstructor
open class RequestEmptyValueChecker {
    fun check(@NotNull @RequestBody request: Map<String, String>, checkList: Array<String>): Boolean {
        var status = true

        for (list in checkList) {
            if (request[list] === null) {
                status = false
            }
        }

        return status
    }
}
