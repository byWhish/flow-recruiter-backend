package flow.com.ar.recruiter.persistence

import flow.com.ar.recruiter.model.FormTemplate
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FormTemplateRepository: CrudRepository<FormTemplate, Long> {
}