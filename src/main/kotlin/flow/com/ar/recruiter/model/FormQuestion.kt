package flow.com.ar.recruiter.model

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
abstract class FormQuestion(
        val label: String,
        val position: Int
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
}