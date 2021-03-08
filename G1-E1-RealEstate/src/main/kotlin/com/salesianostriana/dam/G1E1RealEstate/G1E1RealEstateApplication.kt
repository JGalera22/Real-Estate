package com.salesianostriana.dam.G1E1RealEstate

import com.salesianostriana.dam.G1E1RealEstate.services.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@SpringBootApplication
class G1E1RealEstateApplication: CommandLineRunner{
	@Autowired
	lateinit var usuarioService: UsuarioService

	@Autowired
	lateinit var passwordEncoder: BCryptPasswordEncoder



	override fun run(vararg args: String?) {
		for (usuario in usuarioService.findAll()) {


			usuario.passwd = passwordEncoder.encode(usuario.password)

			usuarioService.save(usuario)
		}
		
	}


}

fun main(args: Array<String>) {
	runApplication<G1E1RealEstateApplication>(*args)


}



