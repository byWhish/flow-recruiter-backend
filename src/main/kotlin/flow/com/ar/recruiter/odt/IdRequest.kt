package flow.com.ar.recruiter.odt

import javax.validation.constraints.NotNull

data class IdRequest(
        @NotNull
        val id: String
) {}