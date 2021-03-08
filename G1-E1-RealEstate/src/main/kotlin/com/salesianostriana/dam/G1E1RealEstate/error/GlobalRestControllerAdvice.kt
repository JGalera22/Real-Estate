package com.salesianostriana.dam.G1E1RealEstate.error

import org.hibernate.validator.internal.engine.path.PathImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import javax.validation.ConstraintViolationException
import java.lang.Exception

@RestControllerAdvice
class GlobalRestControllerAdvice: ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [EntityNotFoundException::class])
    fun handleNotFoundException(ex: EntityNotFoundException) =
        ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ApiError(HttpStatus.NOT_FOUND, ex.message))

    @ExceptionHandler(value = [ExistsException::class])
    fun handleBadRequestException(ex: ExistsException) =
        ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ApiError(HttpStatus.BAD_REQUEST, ex.message))


    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ) : ResponseEntity<Any> =
        ResponseEntity
            .status(status)
            .body(
                ApiError(
                    status,
                    "Error de validación (handleMethodArgumentNotValid)",
                    ex.fieldErrors.map {
                        ApiValidationSubError(it.objectName, it.field, it.rejectedValue, it.defaultMessage)
                    }
                )
            )


    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun handleConstraintViolation(ex : ConstraintViolationException) : ResponseEntity<ApiError> =
        ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(
                ApiError(
                    HttpStatus.BAD_REQUEST,
                    "Error de validación (handleConstraintViolation)",
                    ex.constraintViolations
                    .map { ApiValidationSubError(
                        it.rootBeanClass.simpleName, (it.propertyPath as PathImpl).leafNode.asString(), it.invalidValue, it.message)
                    })

            )


    override fun handleExceptionInternal(
        ex: Exception,
        body: Any?,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val apiError = ApiError(status, ex.message)
        return ResponseEntity.status(status).body(apiError)
    }

}