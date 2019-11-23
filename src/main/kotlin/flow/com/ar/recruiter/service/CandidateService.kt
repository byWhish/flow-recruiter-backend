package flow.com.ar.recruiter.service

import flow.com.ar.recruiter.model.Candidate
import flow.com.ar.recruiter.model.FormQuestionResponse
import flow.com.ar.recruiter.persistence.CandidateRepository
import flow.com.ar.recruiter.persistence.QuestionsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CandidateService {

    @Autowired
    lateinit var candidateRepository: CandidateRepository

    @Autowired
    lateinit var questionsRepository: QuestionsRepository

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

    fun filteredCandidates(filters: List<String>, recruitmentId: Long?): List<Candidate> {
        var filteredIds = listOf<Long>()
                if (recruitmentId == null) {
                    filteredIds = questionsRepository.findFiltered(filters)
                } else {
                    filteredIds = questionsRepository.findRecruitmentFiltered(filters, recruitmentId)
                }
        return candidateRepository.findByIdIn(filteredIds)
    }
}