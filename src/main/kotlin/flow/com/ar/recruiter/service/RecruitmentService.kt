package flow.com.ar.recruiter.service

import flow.com.ar.recruiter.model.Recruitment
import flow.com.ar.recruiter.persistence.RecruitmentRepository
import org.springframework.beans.factory.annotation.Autowired

class RecruitmentService {
    @Autowired
    var repository: RecruitmentRepository? = null

    fun getRecruitment(id: Long): Recruitment? {
        return this.repository?.findById(id)?.orElse(null)
    }
}