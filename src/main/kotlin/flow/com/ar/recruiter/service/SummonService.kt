package flow.com.ar.recruiter.service

import flow.com.ar.recruiter.odt.SummonRequest
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.logging.Logger

@Service
class SummonService {

    @Autowired
    var emailSender : EmailSender? = null

    @Autowired
    val mailContentBuilder: MailContentBuilder? = null

    fun summonCandidates(summonRequest: SummonRequest){
        LOGGER.info("Summon candidates")
        val message: String = mailContentBuilder!!.build("test")
        summonRequest.emails.forEach{ mail ->
                try {
                    emailSender?.sendmail(mail, "test", message)
                } catch (error: Exception) {

                }
        }
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(EmailSender::class.java)
    }
}