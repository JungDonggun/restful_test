package com.co.kr.kotlinautohrization.domain.User.user

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String> {

    fun saveByIdentity(identity: String): List<User>

    fun deleteByNo(no: Number): List<User>

    fun findAllByIdentityAndStatementLike(identity: String, statement: String): List<User>
}
