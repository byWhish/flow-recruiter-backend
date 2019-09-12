package flow.com.ar.recruiter.service

import flow.com.ar.recruiter.model.Appointment
import flow.com.ar.recruiter.persistence.AppointmentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

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

    fun confirmAppointment(id: String) {
        val appointment = this.appointmentRepository.findByconfirmationLink(id)
        appointment.confirmed = true
        this.appointmentRepository.save(appointment)
    }
}