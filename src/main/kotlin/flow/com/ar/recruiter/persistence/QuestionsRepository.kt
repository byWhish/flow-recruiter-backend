package flow.com.ar.recruiter.persistence

import flow.com.ar.recruiter.model.Candidate
import flow.com.ar.recruiter.model.FormQuestionResponse
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface QuestionsRepository: CrudRepository<FormQuestionResponse, Long> {

    @Query("SELECT DISTINCT question FROM FormQuestionResponse")
    fun findDistinctQuestion(): MutableList<String>

    @Query("SELECT DISTINCT response FROM FormQuestionResponse WHERE question = :question")
    fun fidDistinctResponses(@Param("question") question: String): List<String>

    @Query("SELECT DISTINCT parentId FROM FormQuestionResponse WHERE response in :filters")
    fun findFiltered(@Param("filters") filters: List<String>): List<Long>

    @Query("SELECT DISTINCT parentId FROM FormQuestionResponse WHERE recruitmentId = :recruitmentId and response in :filters")
    fun findRecruitmentFiltered(filters: List<String>, recruitmentId: Long): List<Long>
}