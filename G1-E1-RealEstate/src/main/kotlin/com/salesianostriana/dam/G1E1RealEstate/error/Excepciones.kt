package com.salesianostriana.dam.G1E1RealEstate.error

/**
 * Definición de excepciones propias utilizadas con el mecanismo de errores
 */


/**
 * Excepción base que indica que una entidad genérica no se ha encontrado
 */
open class EntityNotFoundException(val msg: String) : RuntimeException(msg)

open class ExistsException(val msg: String) : RuntimeException(msg)

/**
 * Concreción de la clase EntityNotFoundException, indicando que la búsqueda de una entidad
 * no ha sido satisfactoria y debemos devolver un código 404
 */
data class SingleEntityNotFoundException(
    val id: String,
    val javaClass: Class<out Any>
) : EntityNotFoundException("No se puede encontrar la entidad de tipo ${javaClass.name} con ID: ${id}")

/**
 * Concreción de la clase EntityNotFoundException, indicando que la búsqueda de conjunto de entidades
 * no ha sido satisfactoria y debemos devolver un código 404
 */
data class ListEntityNotFoundException(
    val javaClass: Class<out Any>
) : EntityNotFoundException("No se pueden encontrar elementos del tipo ${javaClass.name} para esa consulta")

/**
 * Concreción de la clase ExistsException, indicando que que username introducido ya existe en la base de datos
 * y debemos devolver un código 400
 */
data class UsernameExistsException(
    val username: String
) : ExistsException("El username $username ya existe")

data class FavoriteNotFoundException(
    val javaClass: Class<out Any>
) : EntityNotFoundException("No tiene ninguna vivienda marcada como favorita")

data class ViviendaPropiaNotFoundException(
    val javaClass: Class<out Any>
) : EntityNotFoundException("No tiene ninguna vivienda propia")