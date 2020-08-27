package com.co.kr.kotlinautohrization.domain.User.user

import lombok.Builder
import lombok.Getter
import lombok.NoArgsConstructor

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
class User {
    @Id
    @Column(nullable = false, length = 12)
    private var identity: String? = null

    @Column(nullable = false)
    private var password: String? = null

    @Column(nullable = false, length = 5)
    private var statement: String? = null

    @Column
    private var createdAt: String? = null

    @Builder
    fun User(identity: String, password: String, statement: String, createdAt: String) {
        this.identity = identity
        this.password = password
        this.statement = statement
        this.createdAt = createdAt
    }
}
