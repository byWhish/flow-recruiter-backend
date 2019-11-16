package flow.com.ar.recruiter.odt

import flow.com.ar.recruiter.model.Schedule

data class AppointmentResponse(
        val appointmentId: Long,
        val schedules: MutableList<Schedule>
        )
{}