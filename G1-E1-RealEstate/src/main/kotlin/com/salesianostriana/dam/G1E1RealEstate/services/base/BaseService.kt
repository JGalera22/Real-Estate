package com.salesianostriana.dam.G1E1RealEstate.services.base

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface BaseService<T, ID, R : JpaRepository<T, ID>?> {
    /**
     * Almacenamos una nueva entidad a través del repositorio
     * @param t
     * @return
     */
    fun save(t: T): T

    /**
     * Localizamos una entidad en base a su Id
     *
     * @param id
     * @return
     */
    fun findById(id: ID): Optional<T>?

    /**
     * Obtenemos todas las entidades de un tipo de entidad
     * @return
     */
    fun findAll(): List<T>?

    /**
     * Editamos una instancia de una entidad (si no tiene Id, la insertamos).
     * @param t
     * @return
     */
    fun edit(t: T): T

    /**
     * Eliminamos una instancia de una entidad
     * @param t
     */
    fun delete(t: T)

    /**
     * Eliminamos una instancia en base a su ID
     * @param id
     */
    fun deleteById(id: ID)

    fun existsById(id: ID): Boolean
}