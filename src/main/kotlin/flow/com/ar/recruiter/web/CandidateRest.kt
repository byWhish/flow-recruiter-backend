package flow.com.ar.recruiter.web

import flow.com.ar.recruiter.model.Candidate
import flow.com.ar.recruiter.model.FormQuestionResponse
import flow.com.ar.recruiter.model.Recruitment
import flow.com.ar.recruiter.service.CandidateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("api/private/candidate")

class CandidateRest {

    @Autowired
    lateinit var candidateService: CandidateService

    @PostMapping("/add")
    fun add(@Valid @RequestBody candidate: Candidate): String {
        this.candidateService.save(candidate)
        return "Ok"
    }

    @PostMapping("/add/all")
    fun addAll(@RequestBody candidates: List<Candidate>): String {
        this.candidateService.saveAll(candidates)
        return "Ok"
    }

    @GetMapping("/all")
    fun all(): List<Candidate> {
        return this.candidateService.findAll()
    }

    @GetMapping("/filtered")
    fun filterCandidates(@RequestParam filters: List<String>, @RequestParam recruitmentId: Long?): List<Candidate> {
        return candidateService.filteredCandidates(filters, recruitmentId)
    }
}