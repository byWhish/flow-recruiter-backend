package flow.com.ar.recruiter.service

import com.aventrix.jnanoid.jnanoid.NanoIdUtils
import flow.com.ar.recruiter.odt.SummonRequest
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SummonService {

    @Autowired
    lateinit var emailSender: EmailSender

    @Autowired
    lateinit var mailContentBuilder: MailContentBuilder

    fun inviteCandidates(summonRequest: SummonRequest) {
        LOGGER.info("Inviting candidates")
        val urlquery = NanoIdUtils.randomNanoId();
        val message: String = mailContentBuilder.build("Completar formulareio", urlquery)
        summonRequest.emails.forEach { mail ->
            try {
                emailSender.sendmail(mail, "test", message)
            } catch (error: Exception) {
                LOGGER.error("No fue posible enviar el mail $mail")
            }
        }
    }

    fun summonCandidates(summonRequest: SummonRequest) {
        LOGGER.info("Summoninig candidates")
        val urlquery = NanoIdUtils.randomNanoId();
        val message: String = mailContentBuilder.build("Confirmar asistencia", urlquery)
        summonRequest.emails.forEach { mail ->
            try {
                emailSender.sendmail(mail, "test", message)
            } catch (error: Exception) {
                LOGGER.error("No fue posible enviar el mail $mail")
            }
        }
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(EmailSender::class.java)
    }
}