package flow.com.ar.recruiter.service

import flow.com.ar.recruiter.model.Email
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context

@Service
class MailContentBuilder {

    @Autowired
    lateinit var templateEngine: TemplateEngine

    @Value("\${mail.baseurl}")
    val baseurl: String? = null

    fun build(email: Email, urlquery: String): String {
        val context = Context()
        context.setVariable("message", email.message)
        context.setVariable("title", email.title)
        context.setVariable("label", email.label)
        context.setVariable("link", "$baseurl$urlquery")
        return templateEngine.process("recruitment", context)
    }

}