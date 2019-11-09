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
        val init: Int,
        val end: Int,
        val duration: Int,
        @OneToMany(cascade = [CascadeType.ALL])
        val blocks: MutableList<ScheduleBlock>
){
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = null
}