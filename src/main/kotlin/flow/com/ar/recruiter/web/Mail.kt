package flow.com.ar.recruiter.web

import flow.com.ar.recruiter.model.Candidate
import flow.com.ar.recruiter.model.Recruitment
import flow.com.ar.recruiter.odt.SummonRequest
import flow.com.ar.recruiter.service.SummonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/private/mail")
class Mail {

    @Autowired
    lateinit var summonService : SummonService

    @PostMapping("/{recruitmentId}/summon")
    fun sendSummoningMails(@RequestBody candidates: List<Candidate>, @PathVariable recruitmentId: Long ) : Recruitment {
        return summonService.summonCandidates(candidates, recruitmentId)
    }

    @PostMapping("/{recruitmentId}/invite")
    fun sendInvitationMails(@RequestBody candidates: List<Candidate>, @PathVariable recruitmentId: Long ) : Recruitment {
        return summonService.inviteCandidates(candidates, recruitmentId)
    }
}