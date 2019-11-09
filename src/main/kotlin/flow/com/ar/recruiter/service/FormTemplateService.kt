package flow.com.ar.recruiter.service

import flow.com.ar.recruiter.model.FormQuestionMultiple
import flow.com.ar.recruiter.model.FormQuestionSimple
import flow.com.ar.recruiter.model.FormTemplate
import flow.com.ar.recruiter.persistence.FormTemplateRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FormTemplateService {

    @Autowired
    lateinit var formTemplateRepository: FormTemplateRepository

    fun findById(id: Long): FormTemplate {
        return this.formTemplateRepository.findById(id).orElse(null)
    }

    fun cloneForm(form: FormTemplate): FormTemplate {
        val questions = form.questions.map {
            if (it is FormQuestionSimple) {
                it as FormQuestionSimple
                FormQuestionSimple(it.label, it.position)
            } else {
                it as FormQuestionMultiple
                FormQuestionMultiple(it.label, it.position, it.options!!.toMutableList())
            }
        }.toMutableList()
        return FormTemplate(form.title, questions)
    }
}