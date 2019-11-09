package flow.com.ar.recruiter.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Appointment (
    val confirmationLink: String,
    val timestamp: LocalDateTime,
    @OneToOne
    @JoinColumn(name="candidate_id")
    val candidate: Candidate,
    @OneToMany
    val schedules: MutableList<Schedule>
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var confirmed = false
    var visited = false
    @OneToOne(cascade = [CascadeType.ALL])
    var scheduleBlock: ScheduleBlock? = null
}
