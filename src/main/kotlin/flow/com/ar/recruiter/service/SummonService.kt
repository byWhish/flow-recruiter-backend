package flow.com.ar.recruiter.service

import com.aventrix.jnanoid.jnanoid.NanoIdUtils
import flow.com.ar.recruiter.model.Appointment
import flow.com.ar.recruiter.model.Candidate
import flow.com.ar.recruiter.model.FormInvitation
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

    @Autowired
    lateinit var formTemplateService: FormTemplateService

    fun inviteCandidates(candidates: List<Candidate>, recruitmentId: Long) {
        LOGGER.info("Inviting candidates")
        val recruitment = recruitmentService.getRecruitment(recruitmentId)!!;
        candidates.forEach { candidate ->
            try {
                recruitment.candidates.add(candidate);
                val form = formTemplateService.cloneForm(recruitment.form!!)
                val urlquery = NanoIdUtils.randomNanoId();
                val message: String = mailContentBuilder.build(recruitment.formMail!!, "/form/?id=$urlquery")
                emailSender.sendmail(candidate.email, "Invite", message)
                var invitation = FormInvitation(urlquery, candidate, form)
                recruitment.invitations.add(invitation)
                recruitmentService.postRecruitment(recruitment)
                LOGGER.error("Mail enviado")
            } catch (error: Exception) {
                LOGGER.error("No fue posible enviar el mail ${candidate.email}")
            }
        }
    }

    fun summonCandidates(candidates: List<Candidate>, recruitmentId: Long) {
        LOGGER.info("Summoninig candidates")
        val recruitment = recruitmentService.getRecruitment(recruitmentId)!!;
        candidates.forEach { candidate ->
            try {
                val urlquery = NanoIdUtils.randomNanoId();
                val message: String = mailContentBuilder.build(recruitment.invitationMail!!, "/confirm/?id=$urlquery")
                emailSender.sendmail(candidate.email, "Summoning", message)
                var appointment = Appointment(urlquery, LocalDateTime.now(), candidate, recruitmentId)
                recruitment.appointments.add(appointment)
                this.recruitmentService.postRecruitment(recruitment)
            } catch (error: Exception) {
                LOGGER.error("No fue posible enviar el mail ${candidate.email}")
            }
        }
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(EmailSender::class.java)
    }
}