package flow.com.ar.recruiter.service

import flow.com.ar.recruiter.model.FormInvitation
import flow.com.ar.recruiter.model.FormTemplate
import flow.com.ar.recruiter.odt.IdRequest
import flow.com.ar.recruiter.persistence.FormInvitationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FormInvitationService {

    @Autowired
    lateinit var formInvitationRepository: FormInvitationRepository

    fun save(formInvitation: FormInvitation) {
        this.formInvitationRepository.save(formInvitation)
    }

    fun findAll(): List<FormInvitation> {
        return this.formInvitationRepository.findAll().toMutableList()
    }

    fun confirmForm(response: IdRequest): FormInvitation {
        val form = this.formInvitationRepository.findByFormLink(response.id)
        form.visited = true
        this.formInvitationRepository.save(form)
        return form
    }

    fun completed(response: IdRequest): String {
        val form = this.formInvitationRepository.findByFormLink(response.id)
        form.visited = true
        this.formInvitationRepository.save(form)
        return "Ok"
    }
}