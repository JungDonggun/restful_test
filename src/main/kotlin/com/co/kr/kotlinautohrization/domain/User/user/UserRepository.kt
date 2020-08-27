package com.co.kr.kotlinautohrization.domain.User.user

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String> {

    fun deleteByIdentity(identity: String): List<User>

    fun findAllByIdentityAndStatementLike(identity: String, statement: String): List<User>
}
