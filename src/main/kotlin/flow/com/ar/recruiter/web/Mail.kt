package flow.com.ar.recruiter.web

import flow.com.ar.recruiter.model.Candidate
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
    fun sendSummoningMails(@RequestBody candidates: List<Candidate>, @PathVariable recruitmentId: Long ) : String {
        summonService.summonCandidates(candidates, recruitmentId)
        return "Ok"
    }

    @PostMapping("/{recruitmentId}/invite")
    fun sendInvitationMails(@RequestBody candidates: List<Candidate>, @PathVariable recruitmentId: Long ) : String {
        summonService.inviteCandidates(candidates, recruitmentId)
        return "Ok"
    }
}