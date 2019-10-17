package flow.com.ar.recruiter.web

import flow.com.ar.recruiter.model.FormInvitation
import flow.com.ar.recruiter.model.FormTemplate
import flow.com.ar.recruiter.odt.IdRequest
import flow.com.ar.recruiter.service.FormInvitationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/private/form")
class FormRest {

    @Autowired
    lateinit var formInvitationService: FormInvitationService

    @PostMapping("/confirm")
    fun confirm(@RequestBody id: IdRequest): FormInvitation {
        return formInvitationService.confirmForm(id)
    }

    @GetMapping("/{idForm}")
    fun getForm(@PathVariable idForm : String): FormTemplate {
        return formInvitationService.getFormById(idForm)
    }

    @PostMapping("/completed")
    fun conpleted(@RequestBody id: IdRequest): String {
        return formInvitationService.completed(id)
    }

    @GetMapping("/answer/all")
    fun all(): List<FormInvitation>{
        return formInvitationService.findAll()
    }
}