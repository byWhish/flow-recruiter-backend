package flow.com.ar.recruiter.model

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
class FormQuestionBoolean(label: String, response: String?) : FormQuestion(label, response) {}