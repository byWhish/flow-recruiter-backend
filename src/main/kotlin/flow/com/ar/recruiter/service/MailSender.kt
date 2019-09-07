package flow.com.ar.recruiter.service

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.mail.MessagingException

@Service
class EmailSender {

        @Autowired
        private val sender: JavaMailSender? = null

        @Value("\${mail.enabled}")
        private val mailSendingEnabled: Boolean? = null

        @Throws(MessagingException::class)
        fun sendmail(mailTo: String, subject: String, content: String) {
            if ((mailSendingEnabled)!!) return
            val scheduler = Executors.newScheduledThreadPool(1)

            val task = {
                val message = sender!!.createMimeMessage()
                val helper = MimeMessageHelper(message)

                try {
                    LOGGER.info("cargando parametros para el envio de mail a $mailTo")
                    helper.setTo(mailTo)
                    helper.setSubject(subject)
                    helper.setText(content)
                } catch (e: MessagingException) {
                    LOGGER.error("error al enviar mail de invitacion", e.cause)
                }

                sender.send(message)
                LOGGER.info("el mail fue enviado correctamente a la casilla $mailTo")
            }

            scheduler.schedule(task, 3, TimeUnit.SECONDS)
        }

        companion object {
            private val LOGGER = LoggerFactory.getLogger(EmailSender::class.java)
        }
    }