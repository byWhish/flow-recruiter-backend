package flow.com.ar.recruiter.model

import javax.persistence.*

@Entity
data class FormQuestionResponse(
        val question: String,
        val response: String,
        val parentId: Long,
        val recruitmentId: Long
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
}