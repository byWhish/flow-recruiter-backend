package flow.com.ar.recruiter.persistence

import flow.com.ar.recruiter.model.Appointment
import org.springframework.data.repository.CrudRepository

interface AppointmentRepository: CrudRepository<Appointment, Long> {
}