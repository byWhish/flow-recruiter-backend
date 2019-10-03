package flow.com.ar.recruiter.odt

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class FormTemplateRequest(
        @NotNull
        val title: String,
        @NotEmpty
        var questions: MutableList<@NotNull QuestionRequest>
)