package com.salesianostriana.dam.G1E1RealEstate.upload

import com.salesianostriana.dam.G1E1RealEstate.entities.ImagenVivienda
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.io.UrlResource
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.net.URI
import java.util.*

interface ImgurStorageService : BasicImageStorageService<ImagenVivienda, String, String>

@Service
class ImgurStorageServiceImpl(
        private val imgurService: ImgurService
)
    : ImgurStorageService {

    // El par que se devuelve es la URL de la imagen
    // y el hash de borrado
    val logger: Logger = LoggerFactory.getLogger(ImgurStorageService::class.java)


    override fun store(file: MultipartFile) : Optional<ImagenVivienda> {

        if (!file.isEmpty) {
            var imgReq =
                    NewImageReq(Base64.getEncoder().encodeToString(file.bytes),
                            /*imgToBase64Data(file),*/
                            file.originalFilename.toString())
            var imgRes = imgurService.upload(imgReq)
            if(imgRes.isPresent)
                return Optional.of(ImagenVivienda(imgRes.get().data.id, imgRes.get().data.deletehash))
        }

        return Optional.empty()

    }


    override fun loadAsResource(id: String) : Optional<MediaTypeUrlResource> {
        var response = imgurService.get(id)
        if (response.isPresent) {
            var resource = MediaTypeUrlResource(response.get().data.type, URI.create(response.get().data.link))
            if (resource.exists() || resource.isReadable)
                return Optional.of(resource)
        }

        return Optional.empty()

    }

    override fun delete(deletehash: String) : Unit {
        logger.debug("Eliminando la imagen $deletehash")
        imgurService.delete(deletehash)
    }


}

class MediaTypeUrlResource(
        val mediaType: String, var uri: URI) : UrlResource(uri)