package flow.com.ar.recruiter.odt

import javax.validation.constraints.NotNull

data class ResponseRequest(
        @NotNull
        val response: String,
        @NotNull
        val id: Long
) {}