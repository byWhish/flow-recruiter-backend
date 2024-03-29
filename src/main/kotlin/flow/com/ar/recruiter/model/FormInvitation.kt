package flow.com.ar.recruiter.model

import javax.persistence.*

@Entity
class FormInvitation (
        val formLink: String,
        @ManyToOne
        @JoinColumn(name="candidate_id")
        val candidate: Candidate,
        val parentId: Long
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var completed = false
    var visited = false
    @OneToMany(cascade = [CascadeType.ALL])
    var responses = mutableListOf<FormQuestionResponse>()
}