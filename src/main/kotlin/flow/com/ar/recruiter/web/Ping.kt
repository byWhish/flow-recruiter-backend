package flow.com.ar.recruiter.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Ping {
    @GetMapping("/ping")
    fun pong(): String {
        return "pong"
    }
}