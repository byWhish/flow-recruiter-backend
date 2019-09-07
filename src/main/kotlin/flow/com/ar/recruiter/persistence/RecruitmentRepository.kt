package flow.com.ar.recruiter.persistence

import flow.com.ar.recruiter.model.Recruitment
import org.springframework.data.repository.CrudRepository

interface RecruitmentRepository: CrudRepository<Recruitment, Long> {
}