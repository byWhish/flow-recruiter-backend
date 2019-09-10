package flow.com.ar.recruiter.service

import flow.com.ar.recruiter.model.Candidate
import flow.com.ar.recruiter.persistence.CandidateRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CandidateService {

    @Autowired
    lateinit var candidateRepository: CandidateRepository

    fun save(candidate: Candidate): Unit {
        candidateRepository.save(candidate)
    }

    fun saveAll(candidates: List<Candidate>): Unit {
        candidates.forEach { candidate ->
            this.save(candidate)
        }
    }

    fun findAll(): List<Candidate> {
        return this.candidateRepository.findAll().toMutableList()
    }
}