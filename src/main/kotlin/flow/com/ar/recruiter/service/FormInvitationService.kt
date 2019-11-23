package flow.com.ar.recruiter.service

import flow.com.ar.recruiter.error.ExpiredLinkException
import flow.com.ar.recruiter.model.FormInvitation
import flow.com.ar.recruiter.model.FormQuestion
import flow.com.ar.recruiter.model.FormQuestionResponse
import flow.com.ar.recruiter.model.Recruitment
import flow.com.ar.recruiter.odt.FormResponse
import flow.com.ar.recruiter.odt.FormTemplateResponse
import flow.com.ar.recruiter.odt.ResponseRequest
import flow.com.ar.recruiter.persistence.FormInvitationRepository
import flow.com.ar.recruiter.persistence.RecruitmentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
class FormInvitationService {

    @Autowired
    lateinit var repository: FormInvitationRepository

    @Autowired
    lateinit var recruitmentRepository: RecruitmentRepository

    fun findAll(): List<FormInvitation> {
        return this.repository.findAll().toMutableList()
    }

    fun confirmForm(idLink: String): FormTemplateResponse {
        val formInvitation = this.repository.findByFormLink(idLink)
        if (formInvitation.completed) throw ExpiredLinkException("Este formulario ya fue completado")
        val recruitment : Recruitment = recruitmentRepository.findById(formInvitation.parentId).orElse(null)
        val form = recruitment.form;
        formInvitation.visited = true
        this.repository.save(formInvitation)
        return FormTemplateResponse(form!!, recruitment.id!!)
    }

    fun completed(response: FormResponse): String {
        val formInvitation = this.repository.findByFormLink(response.idLink)
        formInvitation.responses = populateResponses(response.questions, formInvitation.candidate.id!!, response.recruitmentId)
        formInvitation.completed = true
        this.repository.save(formInvitation)
        return "Ok"
    }

    fun populateResponses(responses: List<ResponseRequest>, candidateId: Long, recruitmentId: Long ): MutableList<FormQuestionResponse> {
        return responses.map { FormQuestionResponse(it.question, it.response, candidateId, recruitmentId) }.toMutableList()
    }
}