package flow.com.ar.recruiter.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Email(
        val title: String,
        val message: String,
        val label: String

){
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
}