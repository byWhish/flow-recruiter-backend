package flow.com.ar.recruiter.model

import javax.persistence.ElementCollection
import javax.persistence.Entity

@Entity
class FormQuestionMultiple(
        label: String,
        position: Int,
        @ElementCollection
        var options: MutableList<String>?
) : FormQuestion(label, position){}