package flow.com.ar.recruiter.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Appointment (
    val schedule: LocalDateTime,
    @OneToOne
    @JoinColumn(name="candidate_id")
    val candidate: Candidate,
    val confirmationLink: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var confirmed = false
    var visited = false
}
