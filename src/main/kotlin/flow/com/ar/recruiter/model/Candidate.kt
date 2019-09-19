package flow.com.ar.recruiter.model

import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

@Entity
class Candidate (
    @Column(unique = true)
    @NotNull
    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", message = "El mail tiene un formato incorrecto")
    var email: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
}
