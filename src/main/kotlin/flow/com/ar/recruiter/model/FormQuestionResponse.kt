package flow.com.ar.recruiter.model

import javax.persistence.*

@Entity
data class FormQuestionResponse(
        @OneToOne
        val question: FormQuestion,
        val response: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
}