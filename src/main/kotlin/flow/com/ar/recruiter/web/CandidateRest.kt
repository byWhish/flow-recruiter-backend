package flow.com.ar.recruiter.web

import flow.com.ar.recruiter.model.Candidate
import flow.com.ar.recruiter.service.CandidateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/private/candidate")

class CandidateRest {

    @Autowired
    lateinit var candidateService: CandidateService

    @PostMapping("/add")
    fun add(@RequestBody candidate: Candidate): String {
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
}