package com.salesianostriana.dam.G1E1RealEstate.entities.dto


import com.salesianostriana.dam.G1E1RealEstate.entities.ImagenVivienda
import com.salesianostriana.dam.G1E1RealEstate.entities.Usuario
import com.salesianostriana.dam.G1E1RealEstate.entities.Vivienda
import javax.persistence.Lob
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


data class EditViviendaDto(
        @get:NotBlank(message="{vivienda.titulo.blank}")
        var titulo: String,
        @get:NotBlank(message="{vivienda.descripcion.blank}")
        @Lob
        @get:Size(message = "{vivienda.descripcion.size}", min= 20)
        var descripcion: String,
        @get:NotNull(message="{vivienda.precio.null}")
        @get:Min(0, message = "{vivienda.precio.min}")
        var precio: Double,
        @get:NotNull(message="{vivienda.numeroHabitaciones.null}")
        @get:Min(0, message = "{vivienda.numeroHabitaciones.min}")
        var numeroHabitaciones: Int,
        @get:NotNull(message="{vivienda.metrosCuadrados.null}")
        @get:Min(10, message = "{vivienda.metrosCuadrados.min}")
        var metrosCuadrados: Int,
        @get:NotBlank(message="{vivienda.direccion.blank}")
        var direccion: String,
        @get:NotBlank(message = "{vivienda.localidad.blank}") var localidad: String,
        @get:NotBlank(message = "{vivienda.provincia.blank}") var provincia: String,
        @get:NotBlank(message = "{vivienda.coordenadas.blank}") var coordenadas: String,
        @get:NotBlank(message = "{vivienda.categoria.blank}") var categoria: String,

)

data class GetViviendaDto(
    var id: Long?,
    var titulo: String,
    var precio: Double,
    var numeroHabitaciones: Int,
    var metrosCuadrados: Int,
    var localidad: String,
    var provincia: String,
    var categoria: String,
    var imagen: String?,
    var meGusta: Boolean,

)

data class GetViviendaDetalleDto(
    var id: Long?,
    var titulo: String,
    var descripcion: String,
    var precio: Double,
    var numeroHabitaciones: Int,
    var metrosCuadrados: Int,
    var direccion: String,
    var localidad: String,
    var provincia: String,
    var coordenadas: String,
    var categoria: String,
    var meGusta: Boolean,
    var propietario: GetUsuarioPropiertarioDto,
    var imagenes: List<GetImagenDetalleDto>
)

fun Vivienda.toGetViviendasDto(usuario: Usuario?): GetViviendaDto {

    var favorito = false

    if (usuario != null){
        for (vivienda in usuario.viviendaFav){
            if (vivienda.id == id){
                favorito = true
            }

        }
    }

    var url : String = "http://10.0.2.2:9000/files/"

    if(imagenes.isNotEmpty()){
        return GetViviendaDto(
                id,
                titulo,
                precio,
                numeroHabitaciones,
                metrosCuadrados,
                localidad,
                provincia,
                categoria,
                "${url}${imagenes[0].dataId}",
                favorito
        )
    }
    else{
        return GetViviendaDto(
                id,
                titulo,
                precio,
                numeroHabitaciones,
                metrosCuadrados,
                localidad,
                provincia,
                categoria,
                "",
                favorito
        )
    }
}



fun Vivienda.toGetViviendasDetalleDto(usuario: Usuario?): GetViviendaDetalleDto {

    var favorito = false

    if (usuario != null){
        for (vivienda in usuario.viviendaFav){
            if (vivienda.id == id){
                favorito = true
            }

        }
    }

    var url : String = "http://10.0.2.2:9000/files/"

    var listaImagenes: MutableList<GetImagenDetalleDto> = mutableListOf()
    imagenes.forEach { i ->
        listaImagenes.add(GetImagenDetalleDto(i.id, "${url}${i.dataId}", i.deleteHash))
    }
    var propietario = GetUsuarioPropiertarioDto(propietario!!.nombreCompleto, "https://robohash.org/${propietario!!.username}")

    return GetViviendaDetalleDto(
        id,
        titulo,
        descripcion,
        precio,
        numeroHabitaciones,
        metrosCuadrados,
        direccion,
        localidad,
        provincia,
        coordenadas,
        categoria,
        favorito,
        propietario,
        listaImagenes
    )
}

