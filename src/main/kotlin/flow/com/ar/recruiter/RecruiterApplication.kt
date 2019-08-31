package flow.com.ar.recruiter

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAutoConfiguration
class RecruiterApplication

fun main(args: Array<String>) {
	runApplication<RecruiterApplication>(*args)
}
