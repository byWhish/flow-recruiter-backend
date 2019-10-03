package flow.com.ar.recruiter.service

import com.aventrix.jnanoid.jnanoid.NanoIdUtils
import flow.com.ar.recruiter.model.Appointment
import flow.com.ar.recruiter.model.Candidate
import flow.com.ar.recruiter.model.FormInvitation
import flow.com.ar.recruiter.odt.SummonRequest
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class SummonService {

    @Autowired
    lateinit var emailSender: EmailSender

    @Autowired
    lateinit var mailContentBuilder: MailContentBuilder

    @Autowired
    lateinit var formInvitationService: FormInvitationService

    @Autowired
    lateinit var appointmentService: AppointmentService

    @Autowired
    lateinit var recruitmentService: RecruitmentService

    fun inviteCandidates(candidates: List<Candidate>, recruitmentId: Long) {
        LOGGER.info("Inviting candidates")
        candidates.forEach { candidate ->
            try {
                val recruitment = recruitmentService.getRecruitment(recruitmentId)!!;
                val urlquery = NanoIdUtils.randomNanoId();
                val message: String = mailContentBuilder.build(recruitment.formMail!!, "/form/?id=$urlquery")
                LOGGER.info("Hola como va ?")
                emailSender.sendmail(candidate.email, "Invite", message)
                var invitation = FormInvitation(urlquery, candidate)
                this.formInvitationService.save(invitation)
            } catch (error: Exception) {
                LOGGER.error("No fue posible enviar el mail ${candidate.email}")
            }
        }
    }

    fun summonCandidates(candidates: List<Candidate>, recruitmentId: Long) {
        LOGGER.info("Summoninig candidates")
        candidates.forEach { candidate ->
            try {
                val recruitment = recruitmentService.getRecruitment(recruitmentId)!!;
                val urlquery = NanoIdUtils.randomNanoId();
                val message: String = mailContentBuilder.build(recruitment.invitationMail!!, "/confirm/?id=$urlquery")
                emailSender.sendmail(candidate.email, "Summoning", message)
                var appointment = Appointment(LocalDateTime.now(), candidate, urlquery)
                this.appointmentService.save(appointment)
            } catch (error: Exception) {
                LOGGER.error("No fue posible enviar el mail ${candidate.email}")
            }
        }
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(EmailSender::class.java)
    }
}