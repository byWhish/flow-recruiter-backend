package flow.com.ar.recruiter.persistence

import flow.com.ar.recruiter.model.FormInvitation
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FormInvitationRepository: CrudRepository<FormInvitation, Long> {
    fun findByFormLink(id: String): FormInvitation
}