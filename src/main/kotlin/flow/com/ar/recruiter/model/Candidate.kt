package flow.com.ar.recruiter.model

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
class Candidate (
    var name: String,
    var surname: String,
    var birdDate: LocalDateTime = LocalDateTime.now(),
    @Column(unique = true)
    var email: String,
    var location: String,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
)
