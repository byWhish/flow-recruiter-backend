package flow.com.ar.recruiter.service

import com.aventrix.jnanoid.jnanoid.NanoIdUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context;

@Service
class MailContentBuilder {

    @Autowired
    lateinit var templateEngine: TemplateEngine

    @Value("\${mail.baseurl}")
    val baseurl: String? = null

    fun build(message: String, urlquery: String): String {
        val context = Context()
        context.setVariable("message", message)
        context.setVariable("link", "$baseurl$urlquery")
        return templateEngine.process("recruitment", context)
    }

}