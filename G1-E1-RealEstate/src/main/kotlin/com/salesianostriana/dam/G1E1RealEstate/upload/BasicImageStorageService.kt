package com.salesianostriana.dam.G1E1RealEstate.upload

import org.springframework.web.multipart.MultipartFile
import java.util.*

interface BasicImageStorageService<T, ID, DID> {

    fun store(file : MultipartFile) : Optional<T>

    fun loadAsResource(id : ID) : Optional<MediaTypeUrlResource>

    fun delete(id : DID)


}