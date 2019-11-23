package flow.com.ar.recruiter.web

import flow.com.ar.recruiter.model.Candidate
import flow.com.ar.recruiter.service.FiltersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/private/filters")
class FiltersRest {

    @Autowired
    lateinit var filtersService: FiltersService

    @GetMapping("/all")
    fun all(): List<String> {
        return filtersService.allFilters()
    }

    @GetMapping("/{filter}")
    fun options(@PathVariable filter : String): List<String> {
        return filtersService.allOptions(filter)
    }
}