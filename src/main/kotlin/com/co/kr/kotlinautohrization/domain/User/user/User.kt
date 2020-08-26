package com.co.kr.kotlinautohrization.domain.User.user

import lombok.Builder

import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "users")
class User {
    @Id
    private var no: Number? = null

    @Column(nullable = false, length = 12)
    private var identity: String? = null

    @Column(nullable = false)
    private var password: String? = null


    @Column(nullable = false, length = 5)
    private var statement: String? = null
    
    @Column
    private var createdAt: String? = null

    @Builder
    fun User(no: Number, identity: String, password: String, statement: String, createdAt: String) {
        this.no = no
        this.identity = identity
        this.password = password
        this.statement = statement
        this.createdAt = createdAt
    }
}
