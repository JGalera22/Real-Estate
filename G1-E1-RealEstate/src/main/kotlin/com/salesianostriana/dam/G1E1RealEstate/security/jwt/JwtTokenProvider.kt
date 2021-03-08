package com.salesianostriana.dam.G1E1RealEstate.security.jwt

import com.salesianostriana.dam.G1E1RealEstate.entities.Usuario
import io.jsonwebtoken.*
import io.jsonwebtoken.security.Keys
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*

@Component
class JwtTokenProvider (
    @Value("\${jwtSecreto}") private var jwtSecreto : String,
    @Value("\${jwtDuracionToken}") private var jwtDuracionToken : Long,
    @Value("\${jwtDuracionRefreshToken}") private var jwtDuracionRefreshToken : Long
) {

    // Algunas constantes de utilidad
    companion object {
        const val TOKEN_HEADER = "Authorization"
        const val TOKEN_PREFIX = "Bearer "
        const val TOKEN_TYPE = "JWT"
    }


    // Clase que se encarga del parseo de tokens
    private val parser = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(jwtSecreto.toByteArray())).build()

    private val logger : Logger = LoggerFactory.getLogger(JwtTokenProvider::class.java)

    fun generateToken(authentication: Authentication) : String {
        val usuario: Usuario = authentication.principal as Usuario
        return generateTokens(usuario, false)
    }

    fun generateToken(usuario: Usuario) = generateTokens(usuario,false)

    fun generateRefreshToken(authentication: Authentication) : String {
        val usuario : Usuario = authentication.principal as Usuario
        return generateTokens(usuario, true)
    }

    fun generateRefreshToken(usuario: Usuario) = generateTokens(usuario, true)

    private fun generateTokens(usuario: Usuario, isRefreshToken: Boolean) : String {
        val tokenExpirationDate =
            Date.from(Instant.now().plus(if (isRefreshToken) jwtDuracionRefreshToken else jwtDuracionToken, ChronoUnit.DAYS))

        val builder = Jwts.builder()
            .signWith(Keys.hmacShaKeyFor(jwtSecreto.toByteArray()), SignatureAlgorithm.HS512)
            .setHeaderParam("typ", TOKEN_TYPE)
            .setSubject(usuario.id.toString())
            .setExpiration(tokenExpirationDate)
            .setIssuedAt(Date())
            .claim("refresh", isRefreshToken)

        if (!isRefreshToken){
            builder
                .claim("nombreCompleto", usuario.nombreCompleto)
                .claim("roles", usuario.roles.joinToString())
        }

        return builder.compact()
    }

    /**
     * Método que recibe un token y devuelve el identificador del usuario
     */
    fun getUserIdFromJWT(token: String): Long = (parser.parseClaimsJws(token).body.subject).toLong()

    /**
     * Método que recibe un token de refresco y lo valida
     */
    fun validateRefreshToken(token : String) = validateToken(token, true)

    /**
     * Método que recibe un token de autenticación y lo valida
     */
    fun validateAuthToken(token : String) = validateToken(token, false)


    /**
     * Método privado usado para validar un token. Comprueba que no hay error en la firma,
     * que está bien formado, que no ha expirado, que está completo y soportado.
     * Además, comprueba que es el tipo de token adecuado, es decir, que no estamos
     * usando el token de refresco para hacer peticiones.
     */
    private fun validateToken(token : String, isRefreshToken: Boolean) : Boolean {
        try {
            val claims = parser.parseClaimsJws(token)
            if (isRefreshToken != claims.body["refresh"])
                throw UnsupportedJwtException("No se ha utilizado el token apropiado")
            return true
        } catch (ex : Exception) {
            with(logger) {
                when (ex) {
                    is SignatureException -> info("Error en la firma del token ${ex.message}")
                    is MalformedJwtException -> info("Token malformado ${ex.message}")
                    is ExpiredJwtException -> info("Token expirado ${ex.message}")
                    is UnsupportedJwtException -> info("Token no soportado ${ex.message}")
                    is IllegalArgumentException -> info("Token incompleto (claims vacío) ${ex.message}")
                    else -> info("Error indeterminado")
                }
            }

        }

        return false

    }
}