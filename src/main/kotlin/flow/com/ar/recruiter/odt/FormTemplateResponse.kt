package flow.com.ar.recruiter.odt

import flow.com.ar.recruiter.model.FormTemplate

data class FormTemplateResponse(
        val form : FormTemplate,
        val recruitmentId: Long
) {

}