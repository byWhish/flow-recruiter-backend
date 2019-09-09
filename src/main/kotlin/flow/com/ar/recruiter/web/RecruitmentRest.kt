package flow.com.ar.recruiter.web

import flow.com.ar.recruiter.service.RecruitmentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RecruitmentRest {

    @Autowired
    lateinit var recruitmentService: RecruitmentService

}