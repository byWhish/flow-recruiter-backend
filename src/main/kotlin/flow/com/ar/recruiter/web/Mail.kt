package flow.com.ar.recruiter.web

import flow.com.ar.recruiter.odt.SummonRequest
import flow.com.ar.recruiter.service.SummonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.MailSender
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/private/mail")
class Mail {

    @Autowired
    lateinit var summonService : SummonService

    @PostMapping("/summon")
    fun sendSummoningMails(@RequestBody summonRequest: SummonRequest ) : String {
        summonService.summonCandidates(summonRequest)
        return "Ok"
    }

    @PostMapping("/invite")
    fun sendInvitationMails(@RequestBody summonRequest: SummonRequest ) : String {
        summonService.inviteCandidates(summonRequest)
        return "Ok"
    }
}