package flow.com.ar.recruiter.web

import flow.com.ar.recruiter.model.FormInvitation
import flow.com.ar.recruiter.service.FormInvitationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("api/private/form")
class FormRest {

    @Autowired
    lateinit var formInvitationService: FormInvitationService

    @PostMapping("/confirm")
    fun confirm(@RequestBody id: String): FormInvitation {
        return formInvitationService.confirmForm(id)
    }
}