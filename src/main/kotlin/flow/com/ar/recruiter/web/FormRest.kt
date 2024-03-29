package flow.com.ar.recruiter.web

import flow.com.ar.recruiter.model.FormInvitation
import flow.com.ar.recruiter.odt.FormResponse
import flow.com.ar.recruiter.odt.FormTemplateResponse
import flow.com.ar.recruiter.service.FormInvitationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("api/private/form")
class FormRest {

    @Autowired
    lateinit var formInvitationService: FormInvitationService

//    @PostMapping("/confirm")
//    fun confirm(@RequestBody id: IdRequest): FormInvitation {
//        return formInvitationService.confirmForm(id)
//    }

    @GetMapping("/{idForm}")
    fun getForm(@PathVariable idForm : String): FormTemplateResponse {
        return formInvitationService.confirmForm(idForm)
    }

    @PostMapping("/completed")
    fun conpleted(@Valid @RequestBody response: FormResponse): String {
        return formInvitationService.completed(response)
    }

    @GetMapping("/answer/all")
    fun all(): List<FormInvitation>{
        return formInvitationService.findAll()
    }
}