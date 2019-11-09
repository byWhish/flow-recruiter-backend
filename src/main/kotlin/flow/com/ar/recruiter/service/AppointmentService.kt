package flow.com.ar.recruiter.service

import flow.com.ar.recruiter.error.ExpiredLinkException
import flow.com.ar.recruiter.model.Appointment
import flow.com.ar.recruiter.model.ScheduleBlock
import flow.com.ar.recruiter.odt.AppointmentResponse
import flow.com.ar.recruiter.persistence.AppointmentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class AppointmentService {

    @Autowired
    lateinit var appointmentRepository: AppointmentRepository

    fun save(appointment: Appointment): Unit {
        this.appointmentRepository.save(appointment)
    }

    fun findAll(): List<Appointment> {
        return this.appointmentRepository.findAll().toMutableList()
    }

    fun confirmAppointment(id: String): Appointment {
        val appointment = this.appointmentRepository.findByConfirmationLink(id)
        if (appointment.confirmed) throw ExpiredLinkException("Este link ya no es valido")
        appointment.visited = true
        this.appointmentRepository.save(appointment)
        return appointment
    }

    fun completed(idAppointment: String, idSchedule: Long, idBlock: Long): String {
        val appointment = this.appointmentRepository.findByConfirmationLink(idAppointment)
        val schedule = appointment.schedules.find { it.id == idSchedule }
        val block = schedule?.blocks?.find { it.id == idBlock }
        block?.free = false
        appointment.scheduleBlock = schedule?.blocks?.find { it.id == idBlock }
        appointment.confirmed = true;
        this.appointmentRepository.save(appointment)
        return "ok"
    }
}