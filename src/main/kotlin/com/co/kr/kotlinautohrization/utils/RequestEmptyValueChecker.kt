package com.co.kr.kotlinautohrization.utils

import lombok.RequiredArgsConstructor
import org.jetbrains.annotations.NotNull
import org.springframework.web.bind.annotation.RequestBody

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
open class RequestEmptyValueChecker {
    private val logger: Logger = LoggerFactory.getLogger(RequestEmptyValueChecker::class.java)

    fun check(@NotNull @RequestBody request: Map<String, String>, checkList: Array<String>): Boolean {
        var status = true

        for (list in checkList) {
            if (request[list] === null) {
                status = false
            }
        }

        logger.info("HI JUNG!!!!!!!! $status")

        return status
    }
}
