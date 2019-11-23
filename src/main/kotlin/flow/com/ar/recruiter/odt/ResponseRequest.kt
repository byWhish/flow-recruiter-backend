package flow.com.ar.recruiter.odt

import flow.com.ar.recruiter.model.Recruitment
import javax.validation.constraints.NotNull

data class ResponseRequest(
        @NotNull
        val response: String,
        @NotNull
        val question: String
) {}