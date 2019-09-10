package flow.com.ar.recruiter.persistence

import flow.com.ar.recruiter.model.Recruitment
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RecruitmentRepository: CrudRepository<Recruitment, Long> {
}