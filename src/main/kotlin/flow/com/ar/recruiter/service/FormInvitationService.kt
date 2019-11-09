package flow.com.ar.recruiter.service

import flow.com.ar.recruiter.error.ExpiredLinkException
import flow.com.ar.recruiter.model.FormInvitation
import flow.com.ar.recruiter.model.FormQuestion
import flow.com.ar.recruiter.odt.FormResponse
import flow.com.ar.recruiter.odt.ResponseRequest
import flow.com.ar.recruiter.persistence.FormInvitationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
class FormInvitationService {

    @Autowired
    lateinit var repository: FormInvitationRepository

    fun findAll(): List<FormInvitation> {
        return this.repository.findAll().toMutableList()
    }

    fun confirmForm(idLink: String): FormInvitation {
        val formInvitation = this.repository.findByFormLink(idLink)
        if (formInvitation.completed) throw ExpiredLinkException("Este formulario ya fue completado")
        formInvitation.visited = true
        this.repository.save(formInvitation)
        return formInvitation
    }

    fun completed(response: FormResponse): String {
        val formInvitation = this.repository.findByFormLink(response.idLink)
        updateQuestions(formInvitation.form.questions!!, response.questions)
        formInvitation.completed = true
        this.repository.save(formInvitation)
        return "Ok"
    }

    fun updateQuestions(questions: MutableList<FormQuestion>, responses: List<ResponseRequest>) {
        questions.forEach { question -> question.response = responses.find { it.id == question.id }!!.response }
    }
}