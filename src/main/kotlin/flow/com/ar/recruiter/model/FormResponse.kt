package flow.com.ar.recruiter.model

import javax.persistence.*

@Entity
class FormResponse(
        @OneToOne
        val form: FormTemplate,
        @OneToOne
        val candidate: Candidate
){
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
}