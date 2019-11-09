package flow.com.ar.recruiter.model

import java.util.*
import javax.persistence.*

@Entity
data class ScheduleBlock(
        val time: Date,
        val position: Int
        )
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    @OneToOne(cascade = [CascadeType.ALL])
    var candidate: Candidate? = null
    var free: Boolean = true
}