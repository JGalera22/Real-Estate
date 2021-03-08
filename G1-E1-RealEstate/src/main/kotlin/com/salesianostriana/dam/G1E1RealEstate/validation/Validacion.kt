package com.salesianostriana.dam.G1E1RealEstate.validation

import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean

@Configuration
class ConfiguracionValidacion {

    @Bean
    fun messageSource(): MessageSource {
        var messageSource = ReloadableResourceBundleMessageSource()
        messageSource.setBasename("classpath:message")
        messageSource.setDefaultEncoding("UTF-8")
        return messageSource
    }

    @Bean
    fun getValidator(): LocalValidatorFactoryBean {
        val validator = LocalValidatorFactoryBean()
        validator.setValidationMessageSource(messageSource())
        return validator
    }


}