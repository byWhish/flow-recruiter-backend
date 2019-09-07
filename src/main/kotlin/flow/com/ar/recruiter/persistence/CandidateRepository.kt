package flow.com.ar.recruiter.persistence

import flow.com.ar.recruiter.model.Candidate
import org.springframework.data.repository.CrudRepository

interface CandidateRepository : CrudRepository<Candidate, Long> {
    fun findByEmail(name: String): Candidate?
}