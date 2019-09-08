package flow.com.ar.recruiter.odt

import org.jetbrains.annotations.NotNull
import javax.validation.constraints.Pattern

data class SummonRequest(
        @NotNull
        var recruitmentId: Long,
        @NotNull
        @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", message = "El mail tiene un formato incorrecto")
        var emails: List<String>
)