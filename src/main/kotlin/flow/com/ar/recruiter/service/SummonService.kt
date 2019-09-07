package flow.com.ar.recruiter.service

import flow.com.ar.recruiter.odt.SummonRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.MailSender
import org.springframework.stereotype.Service

@Service
class SummonService {

    @Autowired
    var mailSender : MailSender? = null

    fun summonCandidates(summonRequest: SummonRequest){}
}