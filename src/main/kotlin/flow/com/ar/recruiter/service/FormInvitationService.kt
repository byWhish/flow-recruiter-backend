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
    lateinit var repository: FormInvitationRepository

    fun findAll(): List<FormInvitation> {
        return this.repository.findAll().toMutableList()
    }

    fun confirmForm(idLink: String): FormInvitation {
        val formInvitation = this.repository.findByFormLink(idLink)
        if (formInvitation.completed) throw Exception("Este formulario ya fue completado")
        formInvitation.visited = true
        this.repository.save(formInvitation)
        return formInvitation
    }

    fun completed(response: FormResponse): String {
        val formInvitation = this.repository.findByFormLink(response.idLink)
        formInvitation.form.questions = populateQuestions(response.questions)
        formInvitation.completed = true
        this.repository.save(formInvitation)
        return "Ok"
    }

    private fun populateQuestions(questions: MutableList<QuestionRequest>): MutableList<FormQuestion> {
        return questions.map {
            when (it.type) {
                "single" -> FormQuestionSimple(it.question, it.response)
                "multi" -> FormQuestionMultiple(it.question, it.options, it.response)
                else -> FormQuestionSimple(it.question, it.response)
            }
        }.toMutableList()
    }
}