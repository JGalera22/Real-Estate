package com.salesianostriana.dam.G1E1RealEstate.repositories

import com.salesianostriana.dam.G1E1RealEstate.entities.ImagenVivienda
import org.springframework.data.jpa.repository.JpaRepository

interface ImagenViviendaRepository: JpaRepository<ImagenVivienda, Long> {
    abstract fun findByDeleteHash(deleteHash: String): ImagenVivienda
}

