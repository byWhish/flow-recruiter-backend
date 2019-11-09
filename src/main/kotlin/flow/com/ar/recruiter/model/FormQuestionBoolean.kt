package flow.com.ar.recruiter.model

import javax.persistence.Entity

@Entity
class FormQuestionBoolean(label: String, response: String?, position: Int) : FormQuestion(label, position) {}