package flow.com.ar.recruiter.odt

import javax.validation.constraints.NotNull

data class FormRequest(
        @NotNull
        val recruitmentId: Long,
        @NotNull
        val form: FormTemplateRequest
)