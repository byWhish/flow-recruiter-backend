package flow.com.ar.recruiter.model

import javax.persistence.*

@Entity
class Recruitment (
    var name: String,
    var description: String,
    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "recruitment_id")
    var schedules: MutableList<Schedule>

) {
    @ManyToMany
    @JoinColumn(name = "recruitment_id")
    var candidates = mutableListOf<Candidate>()
    @OneToMany
    @JoinColumn(name = "recruitment_id")
    var appointments = mutableListOf<Appointment>()
    @OneToMany
    @JoinColumn(name = "recruitment_id")
    var responses = mutableListOf<FormResponse>()
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    @OneToOne
    var form: FormTemplate? = null
//    val invitationMail  = null
//    val formMail = null
}