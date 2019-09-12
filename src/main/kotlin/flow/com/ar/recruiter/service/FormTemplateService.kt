package flow.com.ar.recruiter.service

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
}