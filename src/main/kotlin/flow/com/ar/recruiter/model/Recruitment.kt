package flow.com.ar.recruiter.model

import javax.persistence.*

@Entity
class Recruitment (
    var name: String,
    var description: String,
    @OneToMany
    @JoinColumn(name = "recruitment_id")
    var appointments: MutableList<Appointment>,
    @ManyToMany
    @JoinColumn(name = "recruitment_id")
    var candidates: MutableList<Candidate>,
    @OneToOne
    var form: FormTemplate
) {
    @OneToMany
    @JoinColumn(name = "recruitment_id")
    var responses = mutableListOf<FormResponse>()
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
//    val invitationMail  = null
//    val formMail = null
}