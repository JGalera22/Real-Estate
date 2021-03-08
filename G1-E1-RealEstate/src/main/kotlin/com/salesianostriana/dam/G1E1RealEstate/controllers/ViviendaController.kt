package com.salesianostriana.dam.G1E1RealEstate.controllers

import com.salesianostriana.dam.G1E1RealEstate.entities.Usuario
import com.salesianostriana.dam.G1E1RealEstate.entities.Vivienda
import com.salesianostriana.dam.G1E1RealEstate.entities.dto.*
import com.salesianostriana.dam.G1E1RealEstate.error.FavoriteNotFoundException
import com.salesianostriana.dam.G1E1RealEstate.error.ListEntityNotFoundException
import com.salesianostriana.dam.G1E1RealEstate.error.SingleEntityNotFoundException
import com.salesianostriana.dam.G1E1RealEstate.error.ViviendaPropiaNotFoundException
import com.salesianostriana.dam.G1E1RealEstate.services.UsuarioService
import com.salesianostriana.dam.G1E1RealEstate.services.ImagenViviendaService
import com.salesianostriana.dam.G1E1RealEstate.services.ViviendaService
import com.salesianostriana.dam.G1E1RealEstate.upload.ImgurBadRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import java.util.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.server.ResponseStatusException
import javax.validation.Valid

@RestController
@RequestMapping("/viviendas")
class ViviendaController {

    @Autowired
    lateinit var service: ViviendaService

    @Autowired
    lateinit var imagenService: ImagenViviendaService

    @Autowired
    lateinit var usuarioService: UsuarioService


    @GetMapping
    fun getAllViviendas(
        @RequestParam(name = "cat", required = false, defaultValue = "todas") categoria: String,
        @RequestParam(name = "ciu", required = false, defaultValue = "todas") ciudad: String,
        @RequestParam(name = "pre", required = false, defaultValue = "99999999") precio: Int
    )
            : List<GetViviendaDto>? {
        var auth : String = SecurityContextHolder.getContext().authentication.name
        var usuario : Optional<Usuario>? = usuarioService.findByUsername(auth)
        if(usuario!!.isPresent){
            return service.getViviendasFiltradas(categoria, ciudad, precio)?.map { it.toGetViviendasDto(usuario!!.get()) }
                .takeIf { it!!.isNotEmpty() } ?: throw ListEntityNotFoundException(Vivienda::class.java)
        }
        else{
            return service.getViviendasFiltradas(categoria, ciudad, precio)?.map { it.toGetViviendasDto(null) }
                .takeIf { it!!.isNotEmpty() } ?: throw ListEntityNotFoundException(Vivienda::class.java)
        }



    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): GetViviendaDetalleDto {
        var auth : String = SecurityContextHolder.getContext().authentication.name
        var usuario : Optional<Usuario>? = usuarioService.findByUsername(auth)
        if(usuario!!.isPresent){
            return service.findById(id)
                .map { it.toGetViviendasDetalleDto(usuario!!.get()) }
                .orElseThrow {
                    SingleEntityNotFoundException(id.toString(), Vivienda::class.java)
                }
        }
        else{
            return service.findById(id)
                .map { it.toGetViviendasDetalleDto(null) }
                .orElseThrow {
                    SingleEntityNotFoundException(id.toString(), Vivienda::class.java)
                }
        }



    }

    @GetMapping("/favs")
    fun getFavs(): List<GetViviendaDto> {

        var auth : String = SecurityContextHolder.getContext().authentication.name
        var usuario : Optional<Usuario>? = usuarioService.findByUsername(auth)
        return service.getVivivendasFavs(usuario!!.get())
            .map { it.toGetViviendasDto(usuario!!.get()) }
            .takeIf { it.isNotEmpty() } ?: throw FavoriteNotFoundException(Vivienda::class.java)
    }

    @GetMapping("/mine")
    fun getViviendasUsuario(): List<GetViviendaDto> {
        var auth : String = SecurityContextHolder.getContext().authentication.name
        var usuario : Optional<Usuario>? = usuarioService.findByUsername(auth)
        return service.getVivivendasUsuario(usuario!!.get())
            .map { it.toGetViviendasDto(usuario!!.get()) }
            .takeIf { it.isNotEmpty() } ?: throw ViviendaPropiaNotFoundException(Vivienda::class.java)
    }

    @PostMapping
    fun create(@Valid @RequestBody nuevaVivienda: EditViviendaDto): ResponseEntity<GetViviendaDetalleDto> {
        var auth : String = SecurityContextHolder.getContext().authentication.name
        var usuario : Optional<Usuario>? = usuarioService.findByUsername(auth)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(
                service.save(
                    Vivienda(
                        nuevaVivienda.titulo,
                        nuevaVivienda.descripcion,
                        nuevaVivienda.precio,
                        nuevaVivienda.numeroHabitaciones,
                        nuevaVivienda.metrosCuadrados,
                        nuevaVivienda.direccion,
                        nuevaVivienda.localidad,
                        nuevaVivienda.provincia,
                        nuevaVivienda.coordenadas,
                        nuevaVivienda.categoria,
                        usuario!!.get()
                    )
                ).toGetViviendasDetalleDto(usuario!!.get())
            )

    }


    @PutMapping("/{id}")
    fun edit(@Valid @RequestBody editarVivienda: EditViviendaDto, @PathVariable id: Long): GetViviendaDetalleDto {
        var auth : String = SecurityContextHolder.getContext().authentication.name
        var usuario : Optional<Usuario>? = usuarioService.findByUsername(auth)
        return service.findById(id)
            .map { viviendaEncontrada ->
                viviendaEncontrada.titulo = editarVivienda.titulo
                viviendaEncontrada.descripcion = editarVivienda.descripcion
                viviendaEncontrada.precio = editarVivienda.precio
                viviendaEncontrada.numeroHabitaciones = editarVivienda.numeroHabitaciones
                viviendaEncontrada.metrosCuadrados = editarVivienda.metrosCuadrados
                viviendaEncontrada.direccion = editarVivienda.direccion
                viviendaEncontrada.localidad = editarVivienda.localidad
                viviendaEncontrada.provincia = editarVivienda.provincia
                viviendaEncontrada.coordenadas = editarVivienda.coordenadas
                viviendaEncontrada.categoria = editarVivienda.categoria

                service.save(viviendaEncontrada).toGetViviendasDetalleDto(usuario!!.get())
            }
            .orElseThrow { SingleEntityNotFoundException(id.toString(), Vivienda::class.java) }
    }


    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        if (service.existsById(id))
            service.deleteById(id)
        return ResponseEntity.noContent().build()
    }


    @PostMapping("/{id}/img")
    fun createImage(@PathVariable id: Long, @RequestPart("file") file: MultipartFile): ResponseEntity<GetViviendaDetalleDto> {
        var auth : String = SecurityContextHolder.getContext().authentication.name
        var usuario : Optional<Usuario>? = usuarioService.findByUsername(auth)

        var vivienda: Vivienda = service.findById(id).orElse(null)

        if (vivienda != null) {
            try {
                imagenService.save(file, vivienda)
                return ResponseEntity.status(HttpStatus.CREATED)
                    .body(vivienda.toGetViviendasDetalleDto(usuario!!.get()))
            } catch (ex: ImgurBadRequest) {
                throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Error en la subida de la imagen")
            }

        } else {
            throw SingleEntityNotFoundException(id.toString(), Vivienda::class.java)
        }
    }

    @DeleteMapping("/{id}/img/{hash}")
    fun deleteImage(@PathVariable id: Long, @PathVariable hash: String) : ResponseEntity<Any> {
        var vivienda:Vivienda = service.findById(id).orElse(null)
        if(vivienda != null) {
            var i = imagenService.findByDeleteHash(hash)
            println(i!!.dataId)
            imagenService.delete(i)
            vivienda.imagenes.remove(i!!.id)
            service.save(vivienda)


        }
        return ResponseEntity.noContent().build()
    }


    @PostMapping("/favs/{id}")
    fun addFavVivienda(@PathVariable id: Long) : ResponseEntity<GetViviendaDto>{
        var auth : String = SecurityContextHolder.getContext().authentication.name
        var usuario : Optional<Usuario>? = usuarioService.findByUsername(auth)
        var vivienda = service.findById(id).orElse(null)

        if (vivienda != null) {
            usuario!!.get().viviendaFav.add(vivienda)
            usuarioService.save(usuario!!.get())
            return ResponseEntity.status(HttpStatus.CREATED).body(vivienda.toGetViviendasDto(usuario!!.get()))
        } else {
            throw SingleEntityNotFoundException(id.toString(), Vivienda::class.java)
        }



    }

    @DeleteMapping("/favs/{id}")
    fun deleteFavVivienda(@PathVariable id: Long): ResponseEntity<Any> {
        var auth : String = SecurityContextHolder.getContext().authentication.name
        var usuario : Optional<Usuario>? = usuarioService.findByUsername(auth)
        usuario!!.get().viviendaFav.forEach { v ->
            if (v.id == id) {
                usuario!!.get().viviendaFav.remove(v)
                usuarioService.save(usuario!!.get())
            }
        }
        return ResponseEntity.noContent().build()

    }
}



