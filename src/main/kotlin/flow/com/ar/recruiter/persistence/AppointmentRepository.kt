package flow.com.ar.recruiter.persistence

import flow.com.ar.recruiter.model.Appointment
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AppointmentRepository: CrudRepository<Appointment, Long> {
    fun findByConfirmationLink(confirmationLink: String): Appointment
}