package com.salesianostriana.dam.G1E1RealEstate.entities

import javax.persistence.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


@Entity
class Vivienda(

    @get:NotBlank(message="{vivienda.titulo.blank}")
    var titulo: String,
    @get:NotBlank(message="{vivienda.descripcion.blank}")
    @Lob
    @get:Size( message = "{vivienda.descripcion.size}", min= 15)
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
    @get:NotBlank(message = "{vivienda.localidad.blank}")
    var localidad: String,
    @get:NotBlank(message = "{vivienda.provincia.blank}")
    var provincia: String,
    @get:NotBlank(message = "{vivienda.coordenadas.blank}")
    var coordenadas: String,
    @get:NotBlank(message = "{vivienda.categoria.blank}")
    var categoria: String,

    @ManyToOne
    var propietario: Usuario? = null,

    @ManyToMany
    @JoinTable(name = "me_gusta",
        joinColumns = [JoinColumn(name="vivienda_id")],
        inverseJoinColumns = [JoinColumn(name="usuario_id")]
    )
    var usuariosFavs: MutableList<Usuario> = mutableListOf(),



    @OneToMany(mappedBy="vivienda", cascade = arrayOf(CascadeType.ALL), orphanRemoval = true)
    var imagenes: MutableList<ImagenVivienda> = mutableListOf(),

    @Id @GeneratedValue
    var id: Long? = null



) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as Vivienda
        if (id != that.id) return false
        return true
    }


    override fun hashCode(): Int {
        return if (id != null)
            id.hashCode()
        else 0
    }

}