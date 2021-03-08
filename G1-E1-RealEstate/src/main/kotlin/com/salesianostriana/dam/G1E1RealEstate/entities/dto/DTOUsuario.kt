package com.salesianostriana.dam.G1E1RealEstate.entities.dto

import com.salesianostriana.dam.G1E1RealEstate.entities.Usuario
import com.salesianostriana.dam.G1E1RealEstate.entities.Vivienda
import java.time.LocalDate
import javax.persistence.Column
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Past
import javax.validation.constraints.Size

data class GetUsuarioDto(
    var id: Long?,

    @get:NotBlank(message = "{usuario.username.blank}")
    @get:Size( message = "{usuario.username.min}", min= 4, max= 20)
    var username : String,

    @get:Email( message = "{usuario.email.email}")
    var email: String,

    @get:NotBlank(message = "{usuario.nombreCompleto.blank}")
    var nombreCompleto: String,
    var fechaAlta: LocalDate,

    @get:Past(message = "usuario.fechaNacimiento.past")
    var fechaNacimiento: LocalDate,
    var activo: Boolean,
)


fun Usuario.toGetUsuarioDto(): GetUsuarioDto=
    GetUsuarioDto(id, username, email, nombreCompleto, fechaAlta, fechaNacimiento, activo)

data class GetUsuarioRegistroDto(
    var id: Long?,
    var username : String,
    var email: String,
    var nombreCompleto: String,
    var fechaNacimiento: LocalDate,
)

fun Usuario.toGetUsuarioRegistroDto(): GetUsuarioRegistroDto=
    GetUsuarioRegistroDto(id, username, email, nombreCompleto, fechaNacimiento)

data class GetLoginDto(
    var id: Long?,
    var username : String,
    var nombreCompleto: String,
    var email: String,
)

fun Usuario.toGetLoginDto(): GetLoginDto=
    GetLoginDto(id, username, nombreCompleto, email)


data class GetUsuarioPerfilDto(
    var username : String,
    var email: String,
    var nombreCompleto: String,
    var fechaAlta: LocalDate,
    var fechaNacimiento: LocalDate,
    var listaVivienda: MutableList<Vivienda>,
)


fun Usuario.toGetUsuarioPerfilDto(): GetUsuarioPerfilDto=
    GetUsuarioPerfilDto(username, email, nombreCompleto, fechaAlta, fechaNacimiento, listaVivienda)



data class EditarUsuarioDto(
    @get:NotBlank(message = "{usuario.username.blank}")
    @get:Size(message = "{usuario.username.size}", min= 4, max= 20)
    @Column(unique = true)
    var username : String,
    @get:Size(message = "{usuario.password.size}", min= 8, max = 16)
    var passwd : String,
    @get:Email(message = "{usuario.email.email}")
    var email: String,
    @get:NotBlank(message = "{usuario.nombreCompleto.blank}")
    var nombreCompleto: String,
    @get:Past(message = "{usuario.fechaNacimiento.past}")
    var fechaNacimiento: LocalDate,
    var roles: String?,

)

data class UsuarioDTO(
    var username : String,
    var email : String,
    var nombreCompleto: String,
    var roles: String,
    val id: Long? = null
)

fun Usuario.toUserDTO() = UsuarioDTO(username, email, nombreCompleto, roles.joinToString(), id )

fun Usuario.editarUsuarioDto(): EditarUsuarioDto=
    EditarUsuarioDto(username, passwd, email, nombreCompleto, fechaNacimiento, roles.joinToString())


data class LoginUsuarioDto(
    var username : String,
    var password : String,

    )

fun Usuario.loginUsuarioDto(): LoginUsuarioDto=
    LoginUsuarioDto(username, passwd)

data class GetUsuarioPropiertarioDto(
    var nombreCompleto: String,
    var avatar : String
)

