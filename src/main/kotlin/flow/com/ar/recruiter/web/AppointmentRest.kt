package flow.com.ar.recruiter.web

import flow.com.ar.recruiter.model.Appointment
import flow.com.ar.recruiter.model.ScheduleBlock
import flow.com.ar.recruiter.odt.AppointmentResponse
import flow.com.ar.recruiter.service.AppointmentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("api/private/appointment")
class AppointmentRest {

    @Autowired
    lateinit var appointmentService: AppointmentService

    @PostMapping("/add")
    fun save(@Valid @RequestBody appointment: Appointment): String {
        appointmentService.save(appointment)
        return "Ok"
    }

    @GetMapping("/all")
    fun all(): List<Appointment>{
        return this.appointmentService.findAll()
    }

    @GetMapping("/{idAppointment}")
    fun confirm(@PathVariable idAppointment: String): AppointmentResponse {
        return this.appointmentService.confirmAppointment(idAppointment)
    }

    @PostMapping("/completed/{idAppointment}/{idSchedule}/{idBlock}")
    fun completed(@PathVariable idAppointment: String, @PathVariable idSchedule: Long, @PathVariable idBlock: Long): String {
        return this.appointmentService.completed(idAppointment, idSchedule, idBlock)
    }
}
