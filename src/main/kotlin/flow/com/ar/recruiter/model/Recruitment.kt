package flow.com.ar.recruiter.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Recruitment (
    var name: String,
    var description: String,
    @OneToMany
    @JoinColumn(name = "recruitment_id")
    var appointments: List<Appointment>,
    @OneToMany
    @JoinColumn(name = "recruitment_id")
    var candidates: List<Candidate>,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
)