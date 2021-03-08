package com.salesianostriana.dam.G1E1RealEstate.services.base

import org.springframework.beans.factory.annotation.Autowired

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


abstract class BaseServiceImpl<T, ID, R : JpaRepository<T, ID>?> : BaseService<T, ID, R> {
    
    @Autowired
    protected var repositorio: R? = null

    override fun save(t: T): T {
        return repositorio!!.save(t)
    }

    override fun findById(id: ID): Optional<T> {
        return repositorio!!.findById(id)
    }

    override fun findAll(): List<T> {
        return repositorio!!.findAll()
    }

    override fun edit(t: T): T {
        return repositorio!!.save(t)
    }

    override fun delete(t: T) {
        repositorio!!.delete(t)
    }

    override fun deleteById(id: ID) {
        repositorio!!.deleteById(id)
    }

    override fun existsById(id: ID): Boolean {
        return repositorio!!.existsById(id)
    }
}