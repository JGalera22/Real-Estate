package com.salesianostriana.dam.G1E1RealEstate.security.jwt

import com.salesianostriana.dam.G1E1RealEstate.entities.Usuario
import com.salesianostriana.dam.G1E1RealEstate.services.UsuarioService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.WebAuthenticationDetails

import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import org.springframework.web.filter.OncePerRequestFilter
import java.lang.Exception
import java.util.*

import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtAuthorizationFilter(
        private val jwtTokenProvider: JwtTokenProvider,
        private val usuarioService: UsuarioService,
        private val bearerTokenExtractor: BearerTokenExtractor
): OncePerRequestFilter() {

    private val log: Logger = LoggerFactory.getLogger(JwtAuthorizationFilter::class.java)

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {

        try{
            bearerTokenExtractor.getJwtFromRequest(request).ifPresent { token ->
                if(jwtTokenProvider.validateAuthToken(token)) {

                    val userId = jwtTokenProvider.getUserIdFromJWT(token)
                    val user : Usuario = usuarioService.findById(userId).orElseThrow {
                        UsernameNotFoundException("No se ha podido encontrar un usuario con ese ID")
                    }

                    val authentication = UsernamePasswordAuthenticationToken(user, user.roles, user.authorities)
                    authentication.details = WebAuthenticationDetails(request)
                    SecurityContextHolder.getContext().authentication = authentication

                }
            }
            filterChain.doFilter(request, response)
        } catch (ex: Exception) {
            log.info("No se ha podido establecer la autenticación del usuario en el contexto de seguridad")
            log.info(ex.message)
            throw UsernameNotFoundException(ex.message)

        }
    }

}

@Service
class BearerTokenExtractor {

    fun getJwtFromRequest(request: HttpServletRequest): Optional<String>{
        val bearerToken = request.getHeader(JwtTokenProvider.TOKEN_HEADER)
        return if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(JwtTokenProvider.TOKEN_PREFIX)){
            Optional.of(bearerToken.substring(JwtTokenProvider.TOKEN_PREFIX.length, bearerToken.length))
        } else{
            Optional.empty()
        }
    }

}