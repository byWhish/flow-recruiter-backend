package flow.com.ar.recruiter.odt

import org.springframework.lang.NonNull

data class QuestionRequest(
        @NonNull
        val question: String,
        @NonNull
        val position: Int,
        val options: MutableList<String>?,
        val type: String?
)
