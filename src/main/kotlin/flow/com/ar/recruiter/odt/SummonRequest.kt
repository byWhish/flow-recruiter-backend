package flow.com.ar.recruiter.odt

import flow.com.ar.recruiter.model.Recruitment

data class SummonRequest (var recruitmentId: Long, var emails: List<String>)