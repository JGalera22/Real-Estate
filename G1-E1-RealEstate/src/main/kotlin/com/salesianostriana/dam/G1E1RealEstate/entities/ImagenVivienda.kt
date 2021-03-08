package com.salesianostriana.dam.G1E1RealEstate.entities

import org.hibernate.validator.constraints.URL
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.validation.constraints.NotBlank

@Entity
class ImagenVivienda (
        @get:NotBlank(message = "{imagenvivienda.dataid.blank}")
        var dataId: String?,
        @get:NotBlank(message = "{imagenvivienda.deletehash.blank}")
        var deleteHash: String?,
        @ManyToOne
        var vivienda: Vivienda? = null,
        @Id @GeneratedValue val id: Long? = null
)