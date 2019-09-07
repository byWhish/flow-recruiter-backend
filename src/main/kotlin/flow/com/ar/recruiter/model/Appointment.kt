package flow.com.ar.recruiter.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Appointment (
    var schedule: LocalDateTime,
    @OneToOne
    @JoinColumn(name="candidate_id")
    var candidate: Candidate,
    @OneToOne
    @JoinColumn(name="recruitment_id")
    var recruitment: Recruitment,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
)
