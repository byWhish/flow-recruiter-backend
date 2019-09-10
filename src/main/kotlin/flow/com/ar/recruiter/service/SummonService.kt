package flow.com.ar.recruiter.service

import com.aventrix.jnanoid.jnanoid.NanoIdUtils
import flow.com.ar.recruiter.model.Appointment
import flow.com.ar.recruiter.model.FormInvitation
import flow.com.ar.recruiter.odt.SummonRequest
import flow.com.ar.recruiter.persistence.AppointmentRepository
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

    fun inviteCandidates(summonRequest: SummonRequest) {
        LOGGER.info("Inviting candidates")
        summonRequest.candidates.forEach { candidate ->
            try {
                val urlquery = NanoIdUtils.randomNanoId();
                val message: String = mailContentBuilder.build("Completar formulareio", urlquery)
                emailSender.sendmail(candidate.email, "test", message)
                var invitation = FormInvitation(urlquery, candidate)
                this.formInvitationService.save(invitation)
            } catch (error: Exception) {
                LOGGER.error("No fue posible enviar el mail ${candidate.email}")
            }
        }
    }

    fun summonCandidates(summonRequest: SummonRequest) {
        LOGGER.info("Summoninig candidates")
        summonRequest.candidates.forEach { candidate ->
            try {
                val urlquery = NanoIdUtils.randomNanoId();
                val message: String = mailContentBuilder.build("Confirmar asistencia", urlquery)
                emailSender.sendmail(candidate.email, "test", message)
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