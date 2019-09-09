package flow.com.ar.recruiter.model

import javax.persistence.*

@Entity
class FormInvitation (
        val formId: Long,
        val formLink: String,
        @OneToOne
        @JoinColumn(name="candidate_id")
        val candidate: Candidate
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var completed = false
    var visited = false
}