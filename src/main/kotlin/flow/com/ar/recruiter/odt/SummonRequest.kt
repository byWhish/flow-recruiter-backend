package flow.com.ar.recruiter.odt

import flow.com.ar.recruiter.model.Recruitment

data class SummonRequest (var recruitment: Recruitment, var emails: List<String>)