package flow.com.ar.recruiter.odt

data class QuestionRequest(
    val question: String,
    val options: MutableList<String>?,
    val response: String?,
    val type: String?
)