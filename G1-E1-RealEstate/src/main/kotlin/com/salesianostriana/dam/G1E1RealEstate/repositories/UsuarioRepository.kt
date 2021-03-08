package com.salesianostriana.dam.G1E1RealEstate.repositories

import com.salesianostriana.dam.G1E1RealEstate.entities.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface UsuarioRepository : JpaRepository<Usuario, Long> {

    fun findByUsername(username: String) : Optional<Usuario>
}