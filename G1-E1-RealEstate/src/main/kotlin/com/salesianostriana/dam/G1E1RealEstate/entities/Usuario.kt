package com.salesianostriana.dam.G1E1RealEstate.entities

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Past
import javax.validation.constraints.Size
import kotlin.collections.HashSet


@Entity
class Usuario(

    @get:NotBlank(message = "{usuario.username.blank}")
    @get:Size( message = "{usuario.username.size}", min= 4, max= 20)
    @Column(unique = true)
    private var username : String,

    @get:Size( message = "{usuario.password.size}", min= 8, max = 100)
    var passwd: String,

    @get:Email( message = "{usuario.email.email}")
    var email: String,

    @get:NotBlank(message = "{usuario.nombreCompleto.blank}")
    var nombreCompleto: String,

    @get:Past(message = "{usuario.fechaNacimiento.past}")
    @JsonFormat(pattern="yyyy-MM-dd")
    var fechaNacimiento: LocalDate,

    @ElementCollection(fetch = FetchType.EAGER)
    val roles: MutableSet<String> = HashSet(),

    var fechaAlta: LocalDate = LocalDate.now(),

    private val nonExpired: Boolean = true,

    private val nonLocked: Boolean = true,

    var activo: Boolean = true,

    private val credentialIsNonExpired: Boolean = true,

    @ManyToMany
    @JoinTable(name = "me_gusta",
        joinColumns = [JoinColumn(name="usuario_id")],
        inverseJoinColumns = [JoinColumn(name="vivienda_id")]
    )
    var viviendaFav: MutableList<Vivienda> = mutableListOf(),


    @OneToMany(mappedBy = "propietario")
    var listaVivienda: MutableList<Vivienda> = mutableListOf(),


    @Id @GeneratedValue val id : Long? = null

) : UserDetails {

    constructor(username: String, password: String, email: String, nombreCompleto: String, fechaNacimiento: LocalDate, role: String) :
            this(
                username, password, email, nombreCompleto, fechaNacimiento, mutableSetOf(role),
                LocalDate.now(), true, true, true, true
            )

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return roles.map { SimpleGrantedAuthority("ROLE_$it") }.toMutableList()
    }

    override fun isEnabled()= activo
    override fun getUsername() = username
    override fun getPassword() = passwd
    override fun isCredentialsNonExpired() = credentialIsNonExpired
    override fun isAccountNonExpired() = nonExpired
    override fun isAccountNonLocked() = nonLocked


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as Usuario
        if (id != that.id) return false
        return true
    }


    override fun hashCode(): Int {
        return if (id != null)
            id.hashCode()
        else 0
    }

}
