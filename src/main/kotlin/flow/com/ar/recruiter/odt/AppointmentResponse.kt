package flow.com.ar.recruiter.odt

import flow.com.ar.recruiter.model.ScheduleBlock

data class AppointmentResponse(
        val id: String,
        val block: ScheduleBlock
        )
{}