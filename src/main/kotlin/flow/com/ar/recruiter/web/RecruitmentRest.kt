package flow.com.ar.recruiter.web

import flow.com.ar.recruiter.model.Recruitment
import flow.com.ar.recruiter.service.RecruitmentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/private/project")
class RecruitmentRest {

    @Autowired
    lateinit var recruitmentService: RecruitmentService

    @PostMapping("/add")
    fun add(@RequestBody recruitment: Recruitment): String {
        return recruitmentService.postRecruitment(recruitment)
    }

    @GetMapping("/all")
    fun all(): List<Recruitment> {
        return recruitmentService.getRecruitment()
    }
}