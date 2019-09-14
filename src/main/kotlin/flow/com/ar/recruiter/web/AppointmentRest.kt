package flow.com.ar.recruiter.web

import flow.com.ar.recruiter.model.Appointment
import flow.com.ar.recruiter.service.AppointmentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/private/appointment")
class AppointmentRest {

    @Autowired
    lateinit var appointmentService: AppointmentService

    @PostMapping("/add")
    fun save(@RequestBody appointment: Appointment): String {
        appointmentService.save(appointment)
        return "Ok"
    }

    @GetMapping("/all")
    fun all(): List<Appointment>{
        return this.appointmentService.findAll()
    }

    @PostMapping("/confirm")
    fun confirm(@RequestBody id: String): String {
        this.appointmentService.confirmAppointment(id)
        return "Ok"
    }
}
