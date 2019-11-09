package flow.com.ar.recruiter.error

import org.springframework.http.HttpStatus

internal class ApiError private constructor() {

    var status: HttpStatus? = null
    var message: String? = null

    constructor(status: HttpStatus) : this() {
        this.status = status
    }

    constructor(status: HttpStatus, ex: Throwable) : this() {
        this.status = status
        this.message = "Unexpected error"
    }

    constructor(status: HttpStatus, message: String) : this() {
        this.status = status
        this.message = message
    }
}