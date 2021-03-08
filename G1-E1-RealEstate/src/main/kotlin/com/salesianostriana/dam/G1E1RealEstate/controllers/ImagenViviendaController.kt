package com.salesianostriana.dam.G1E1RealEstate.controllers

import com.salesianostriana.dam.G1E1RealEstate.services.ImagenViviendaService
import com.salesianostriana.dam.G1E1RealEstate.upload.ImgurImageNotFoundException
import com.salesianostriana.dam.G1E1RealEstate.upload.ImgurStorageService
import com.salesianostriana.dam.G1E1RealEstate.upload.MediaTypeUrlResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*
import kotlin.jvm.Throws

@RestController
class ImagenViviendaController {

    @Autowired
    lateinit var servicio: ImagenViviendaService

    @Autowired
    lateinit var imgurStorageService: ImgurStorageService


    @Throws(ResponseStatusException::class)
    @GetMapping("/files/{id}")
    fun get(@PathVariable id: String) : ResponseEntity<Resource> {
        var resource: Optional<MediaTypeUrlResource>
        try {
            resource = imgurStorageService.loadAsResource(id)
            if (resource.isPresent) {
                return ResponseEntity.ok().contentType(MediaType.parseMediaType(resource.get().mediaType)).body(resource.get())
            }
            return ResponseEntity.noContent().build()
        } catch (ex: ImgurImageNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Imagen no encontrada")
        }

    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Void> {
        var imagen = servicio.findById(id).orElse(null)
        if(imagen != null){
            servicio.delete(imagen)

        }
        return ResponseEntity.noContent().build()
    }
}

