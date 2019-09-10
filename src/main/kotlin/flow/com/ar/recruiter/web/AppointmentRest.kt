package flow.com.ar.recruiter.web

import flow.com.ar.recruiter.model.Appointment
import flow.com.ar.recruiter.service.AppointmentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/private/appointment")
class AppointmentRest {

    @Autowired
    lateinit var appointmentService: AppointmentService

    fun save(@RequestBody appointment: Appointment): String {
        appointmentService.save(appointment)
        return "Ok"
    }
}
