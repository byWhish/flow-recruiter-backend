package flow.com.ar.recruiter.model

import javax.persistence.*

@Entity
class FormInvitation (
        val formLink: String,
        @ManyToOne
        @JoinColumn(name="candidate_id")
        val candidate: Candidate,
        @OneToOne(cascade = [CascadeType.ALL])
        val form: FormTemplate
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var completed = false
    var visited = false
}