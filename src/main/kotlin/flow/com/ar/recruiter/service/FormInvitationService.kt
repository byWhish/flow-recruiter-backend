package flow.com.ar.recruiter.service

import flow.com.ar.recruiter.model.*
import flow.com.ar.recruiter.odt.FormResponse
import flow.com.ar.recruiter.odt.IdRequest
import flow.com.ar.recruiter.odt.QuestionRequest
import flow.com.ar.recruiter.persistence.FormInvitationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FormInvitationService {

    @Autowired
    lateinit var formInvitationRepository: FormInvitationRepository

    fun findAll(): List<FormInvitation> {
        return this.formInvitationRepository.findAll().toMutableList()
    }

    fun confirmForm(idLink: String): FormInvitation {
        val formInvitation = this.formInvitationRepository.findByFormLink(idLink)
        formInvitation.visited = true
        this.formInvitationRepository.save(formInvitation)
        return formInvitation
    }

    fun completed(response: FormResponse): String {
        val formInvitation = this.formInvitationRepository.findByFormLink(response.idLink)
        formInvitation.form.questions = populateQuestions(response.questions)
        formInvitation.completed = true
        this.formInvitationRepository.save(formInvitation)
        return "Ok"
    }

    private fun populateQuestions(questions: MutableList<QuestionRequest>): MutableList<FormQuestion> {
        return questions.map {
            when(it.type) {
                "single" -> FormQuestionSimple(it.question)
                "multi" -> FormQuestionMultiple(it.question, it.options)
                else -> FormQuestionSimple(it.question)
            }
        }.toMutableList()
    }

//    fun getFormById(idForm: String): FormInvitation {
//        val formInvitation = this.formInvitationRepository.findByFormLink(idForm)
//        formInvitation.visited = true;
//        this.formInvitationRepository.save(formInvitation)
//        return formInvitation
//    }
}