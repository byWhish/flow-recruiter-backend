package flow.com.ar.recruiter.model

import javax.persistence.Entity

@Entity
class FormQuestionSimple(label: String, position: Int) : FormQuestion(label, position) {}