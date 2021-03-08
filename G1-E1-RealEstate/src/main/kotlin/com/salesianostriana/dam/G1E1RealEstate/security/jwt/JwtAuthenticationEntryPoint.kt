package com.salesianostriana.dam.G1E1RealEstate.security.jwt

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpStatus
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtAuthenticationEntryPoint (
        val mapper: ObjectMapper
        ): AuthenticationEntryPoint {


    override fun commence(request: HttpServletRequest?, response: HttpServletResponse?, authException: AuthenticationException?) {
        response?.status = HttpStatus.UNAUTHORIZED.value()
        response?.contentType = "application/json"
        response?.writer?.println(mapper.writeValueAsString(authException?.message?.let { MensajeError(it) }))


    }



}

data class MensajeError(
    val mensaje: String
)