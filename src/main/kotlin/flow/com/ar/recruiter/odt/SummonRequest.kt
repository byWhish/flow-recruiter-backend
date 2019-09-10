package flow.com.ar.recruiter.odt

import flow.com.ar.recruiter.model.Candidate
import org.jetbrains.annotations.NotNull
import javax.validation.constraints.Pattern

data class SummonRequest(
        @NotNull
        var recruitmentId: Long,
        @NotNull
        var candidates: List<Candidate>
)