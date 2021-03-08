package com.salesianostriana.dam.G1E1RealEstate.services

import com.salesianostriana.dam.G1E1RealEstate.entities.ImagenVivienda
import com.salesianostriana.dam.G1E1RealEstate.entities.Vivienda
import com.salesianostriana.dam.G1E1RealEstate.repositories.ImagenViviendaRepository
import com.salesianostriana.dam.G1E1RealEstate.services.base.BaseServiceImpl
import com.salesianostriana.dam.G1E1RealEstate.upload.ImgurStorageService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.util.*

@Service
class ImagenViviendaService(
        private val imageStorageService: ImgurStorageService
): BaseServiceImpl<ImagenVivienda, Long, ImagenViviendaRepository>() {

    val logger: Logger = LoggerFactory.getLogger(ImagenViviendaService::class.java)


    fun save(file: MultipartFile, vivienda: Vivienda) : ImagenVivienda {
        var imagen: ImagenVivienda
        var image : Optional<ImagenVivienda> = Optional.empty()
        if (!file.isEmpty) {
            image = imageStorageService.store(file)
        }

        imagen = image.orElse(null)
        imagen.vivienda = vivienda
        return save(imagen)
    }

    override fun delete(i: ImagenVivienda) {
        logger.debug("Eliminando la entidad $i")
        i?.let { it.deleteHash?.let { it1 -> imageStorageService.delete(it1) } }
        super.delete(i)

    }

    fun findByDeleteHash(deleteHash: String) = repositorio?.findByDeleteHash(deleteHash)

}