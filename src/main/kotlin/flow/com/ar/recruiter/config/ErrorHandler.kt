package flow.com.ar.recruiter.config

import flow.com.ar.recruiter.error.ApiError
import flow.com.ar.recruiter.error.ExpiredLinkException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.web.context.request.WebRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class ErrorHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [IllegalArgumentException::class, IllegalStateException::class])
    protected fun handleConflict(
            ex: RuntimeException, request: WebRequest): ResponseEntity<Any> {
        val bodyOfResponse = "This should be application specific"
        return handleExceptionInternal(ex, bodyOfResponse,
                HttpHeaders(), HttpStatus.CONFLICT, request)
    }

    @ExceptionHandler(ExpiredLinkException::class)
    protected fun handleExpiredLink(ex: ExpiredLinkException): ResponseEntity<Any> {
        val apiError = ApiError(HttpStatus.CONFLICT)
        apiError.message = ex.message
        return buildResponseEntity(apiError)
    }

    private fun buildResponseEntity(apiError: ApiError): ResponseEntity<Any> {
        return ResponseEntity(apiError, apiError.status!!)
    }
}
