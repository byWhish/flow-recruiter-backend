package flow.com.ar.recruiter.model

import javax.persistence.*

@Entity
class FormResponse(
        @OneToOne
        var form: FormTemplate,
        @OneToOne
        var candidate: Candidate
){
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
}