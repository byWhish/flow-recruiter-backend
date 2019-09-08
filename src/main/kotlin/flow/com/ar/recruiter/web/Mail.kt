package flow.com.ar.recruiter.web

import flow.com.ar.recruiter.odt.SummonRequest
import flow.com.ar.recruiter.service.SummonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.MailSender
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class Mail {

    @Autowired
    var summonService : SummonService? = null

    @PostMapping("/summon")
    fun sendMails(@RequestBody summonRequest: SummonRequest ) : String {
        summonService?.summonCandidates(summonRequest)
        return "Ok"
    }
}