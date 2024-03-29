package flow.com.ar.recruiter.service

import flow.com.ar.recruiter.model.*
import flow.com.ar.recruiter.odt.FormRequest
import flow.com.ar.recruiter.odt.FormTemplateRequest
import flow.com.ar.recruiter.odt.QuestionRequest
import flow.com.ar.recruiter.persistence.RecruitmentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RecruitmentService {
    @Autowired
    lateinit var repository: RecruitmentRepository

    fun getRecruitment(id: Long): Recruitment? {
        return this.repository.findById(id)?.orElse(null)
    }

    fun postRecruitment(recruitment: Recruitment): Recruitment {
        repository.save(recruitment)
        return recruitment
    }

    fun getAllRecruitment(): List<Recruitment> {
        return repository.findAll().toMutableList()
    }

    fun addForm(formRequest: FormTemplateRequest, recruitmentId: Long): Recruitment {
        val recruitment : Recruitment = repository.findById(recruitmentId).orElse(null)
        recruitment.form = generateFormFromRequest(formRequest)
        repository.save(recruitment)
        return recruitment
    }

    private fun generateFormFromRequest(form: FormTemplateRequest): FormTemplate {
        return FormTemplate(
                title = form.title,
                questions = populateQuestions(form.questions)
        )
    }

    private fun populateQuestions(questions: MutableList<QuestionRequest>): MutableList<FormQuestion> {
        return questions.map {
            when(it.type) {
                "single" -> FormQuestionSimple(it.question, it.position)
                "multi" -> FormQuestionMultiple(it.question, it.position, it.options)
                else -> FormQuestionSimple(it.question, it.position)
            }
        }.toMutableList()
    }

    fun addMail(email: Email, type: String, recruitmentId: Long): Recruitment {
        val recruitment: Recruitment = repository.findById(recruitmentId).orElse(null)
        when(type){
            "invite" -> recruitment.invitationMail = email
            "form" -> recruitment.formMail = email
            else -> false
        }
        repository.save(recruitment)
        return recruitment
    }

    fun delete(recruitmentId: Long): List<Recruitment> {
        repository.deleteById(recruitmentId)
        return repository.findAll().toMutableList()
    }

    fun getAllInterested(recruitmentId: Long): List<Candidate> {
        val recruitment = this.getRecruitment(recruitmentId)
        return recruitment!!.invitations.filter { formInvitation -> formInvitation.completed }.map { filtered -> filtered.candidate }
    }
}