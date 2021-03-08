package com.salesianostriana.dam.G1E1RealEstate.services

import com.salesianostriana.dam.G1E1RealEstate.entities.Usuario
import com.salesianostriana.dam.G1E1RealEstate.entities.Vivienda
import com.salesianostriana.dam.G1E1RealEstate.repositories.VivivendaRepository
import com.salesianostriana.dam.G1E1RealEstate.services.base.BaseServiceImpl
import org.springframework.stereotype.Service
import java.util.*

@Service
class ViviendaService(): BaseServiceImpl<Vivienda, Long, VivivendaRepository>(){

    fun getViviendasFiltradas(categoria: String, ciudad: String, precio: Int): List<Vivienda>? {
        var lista: List<Vivienda>? = repositorio?.findAll()
        if(categoria != "todas"){
            lista = lista?.filter { it.categoria.toLowerCase() == categoria.toLowerCase() }
        }
        if (ciudad != "todas"){
            lista = lista?.filter { it.localidad.toLowerCase() == ciudad.toLowerCase() }
        }
        if (precio != 99999999){
            lista = lista?.filter { it.precio <= precio.toDouble() }
        }
        return lista
    }

    fun getVivivendasFavs (usuario: Usuario) : List<Vivienda> = usuario.viviendaFav


    fun getVivivendasUsuario (usuario: Usuario) : List<Vivienda> = usuario.listaVivienda




}