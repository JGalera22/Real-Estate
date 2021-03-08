package com.salesianostriana.dam.G1E1RealEstate.entities.dto

import com.salesianostriana.dam.G1E1RealEstate.entities.ImagenVivienda
import org.hibernate.validator.constraints.URL


data class GetImagenDto(
        var url:String
)

data class GetImagenDetalleDto(
        var id: Long?,
        var url: String?,
        var deleteHash: String?
)

