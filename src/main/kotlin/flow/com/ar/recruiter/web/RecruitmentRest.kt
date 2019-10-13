package flow.com.ar.recruiter.web

import flow.com.ar.recruiter.model.Email
import flow.com.ar.recruiter.model.Recruitment
import flow.com.ar.recruiter.odt.FormTemplateRequest
import flow.com.ar.recruiter.service.RecruitmentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/private/project")
class RecruitmentRest {

    @Autowired
    lateinit var recruitmentService: RecruitmentService

    @PostMapping("/add")
    fun add(@RequestBody recruitment: Recruitment): Recruitment {
        return recruitmentService.postRecruitment(recruitment)
    }

    @GetMapping("/{recruitmentId}")
    fun getSingle(@PathVariable recruitmentId: Long): Recruitment? {
        return recruitmentService.getRecruitment(recruitmentId)
    }

    @GetMapping("/all")
    fun all(): List<Recruitment> {
        return recruitmentService.getAllRecruitment()
    }

    @PostMapping("/form/{recruitmentId}")
    fun addForm(@RequestBody formRequest: FormTemplateRequest, @PathVariable recruitmentId: Long): Recruitment {
        return recruitmentService.addForm(formRequest, recruitmentId)
    }

    @PostMapping("/mail/{recruitmentId}/{type}")
    fun addMail(@RequestBody email: Email, @PathVariable type: String, @PathVariable recruitmentId: Long): Recruitment {
        return recruitmentService.addMail(email, type, recruitmentId)
    }
}