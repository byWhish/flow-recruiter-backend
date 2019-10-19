package flow.com.ar.recruiter.model

import javax.persistence.DiscriminatorValue
import javax.persistence.ElementCollection
import javax.persistence.Entity

@Entity
class FormQuestionMultiple(
        label: String,
        @ElementCollection
        var options: MutableList<String>?,
        response: String?

) : FormQuestion(label, response){}