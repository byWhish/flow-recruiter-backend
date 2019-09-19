package flow.com.ar.recruiter.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.CollectionType
import java.util.*
import javax.persistence.*

@Entity
class Schedule(
        val date: Date,
        @ElementCollection
        val timeRange: MutableList<Int>,
        val duration: Int
){
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @JsonIgnore
        val id: Long? = null
}