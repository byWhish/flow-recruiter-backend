package flow.com.ar.recruiter.model

import javax.persistence.*

@Entity
class FormTemplate(
        @OneToMany
        var questions: MutableList<FormQuestion>
){
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
}