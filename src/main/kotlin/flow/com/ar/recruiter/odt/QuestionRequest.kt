package flow.com.ar.recruiter.odt

import org.springframework.lang.NonNull

data class QuestionRequest(
        @NonNull
        val question: String,
        val options: MutableList<String>?,
        val response: String?,
        val type: String?
)
