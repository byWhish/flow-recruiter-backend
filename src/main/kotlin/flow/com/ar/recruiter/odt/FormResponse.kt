package flow.com.ar.recruiter.odt

import flow.com.ar.recruiter.model.FormQuestion
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class FormResponse(
        @NotNull
        val id: Long,
        @NotNull
        val idLink: String,
        @NotEmpty
        val questions: MutableList<QuestionRequest>
) {}