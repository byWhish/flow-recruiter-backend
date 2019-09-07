package flow.com.ar.recruiter.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context;

@Service
class MailContentBuilder @Autowired
constructor(private val templateEngine: TemplateEngine) {

    fun build(message: String): String {
        val context = Context()
        context.setVariable("message", message)
        return templateEngine.process("mailTemplate", context)
    }

}