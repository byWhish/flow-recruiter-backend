package flow.com.ar.recruiter.service

import flow.com.ar.recruiter.model.Candidate
import flow.com.ar.recruiter.persistence.QuestionsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FiltersService {

    @Autowired
    lateinit var questionsRespository: QuestionsRepository

    fun allFilters(): MutableList<String> {
        return questionsRespository.findDistinctQuestion()
    }

    fun allOptions(filter: String): List<String> {
        return questionsRespository.fidDistinctResponses(filter)
    }
}