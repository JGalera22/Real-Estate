package com.salesianostriana.dam.G1E1RealEstate.services

import com.salesianostriana.dam.G1E1RealEstate.entities.Usuario
import com.salesianostriana.dam.G1E1RealEstate.entities.dto.EditarUsuarioDto
import com.salesianostriana.dam.G1E1RealEstate.repositories.UsuarioRepository
import com.salesianostriana.dam.G1E1RealEstate.services.base.BaseServiceImpl
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class UsuarioService(private val encoder: PasswordEncoder) : BaseServiceImpl<Usuario, Long, UsuarioRepository>() {

    fun create(newUser: EditarUsuarioDto): Optional<Usuario> {
        if(findByUsername(newUser.username)!!.isPresent)
            return Optional.empty()
        return Optional.of(
            with(newUser) {
                repositorio!!.save(
                    Usuario(username, encoder.encode(passwd), email, nombreCompleto, fechaNacimiento, "USER")
                )
            }
        )
    }

    fun findByUsername(username: String) = repositorio?.findByUsername(username)

}