package com.co.kr.kotlinautohrization.config

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import lombok.RequiredArgsConstructor
import org.springframework.util.StringUtils
import java.util.*
import javax.servlet.http.HttpServletRequest

@RequiredArgsConstructor
class JwtTokenProvider {
    private val secretKey: String = "JUNGDONGGUN_RESTFUL_AUTH_KEY_!@#"

    fun createToken(identity: String): String {
        val claims: Claims = Jwts.claims().setSubject(identity)
        val tokenValidMilliseconds = 1000L * 60 * 60 * 24
        val now = Date()

        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("Donggun")
                .setIssuedAt(now)
                .setExpiration(Date(now.time + tokenValidMilliseconds))
                .signWith(SignatureAlgorithm.ES512, secretKey)
                .compact()

    }

    fun resolveToken(request: HttpServletRequest): String {
        val bearerToken = request.getHeader("Authorization")

        return if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
            bearerToken.substring(7)
        } else {
            ""
        }
    }

    fun validateToken(token: String): Boolean {
        return try {
            val claims: Jws<Claims> = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)

            !claims.body.expiration.before(Date())
        } catch (error: Exception) {
            false
        }
    }

//    fun getAuthentication(token: String): Authentication {
//        val userDetails: UserDetails = "Jung"

//    }
}
