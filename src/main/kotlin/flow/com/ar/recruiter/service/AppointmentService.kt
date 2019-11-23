package flow.com.ar.recruiter.service

import flow.com.ar.recruiter.error.ExpiredLinkException
import flow.com.ar.recruiter.model.Appointment
import flow.com.ar.recruiter.model.Recruitment
import flow.com.ar.recruiter.model.ScheduleBlock
import flow.com.ar.recruiter.odt.AppointmentResponse
import flow.com.ar.recruiter.persistence.AppointmentRepository
import flow.com.ar.recruiter.persistence.RecruitmentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class AppointmentService {

    @Autowired
    lateinit var appointmentRepository: AppointmentRepository

    @Autowired
    lateinit var recruitmentRepository: RecruitmentRepository

    fun save(appointment: Appointment) {
        this.appointmentRepository.save(appointment)
    }

    fun findAll(): List<Appointment> {
        return this.appointmentRepository.findAll().toMutableList()
    }

    fun confirmAppointment(id: String): AppointmentResponse {
        val appointment = this.appointmentRepository.findByConfirmationLink(id)
        if (appointment.confirmed) throw ExpiredLinkException("Este link ya no es valido")
        appointment.visited = true
        val recruitment : Recruitment = recruitmentRepository.findById(appointment.parentId).orElse(null)
        this.appointmentRepository.save(appointment)
        return AppointmentResponse(appointment.id!!, recruitment.schedules)
    }

    fun completed(idAppointment: String, idSchedule: Long, idBlock: Long): String {
        val appointment = this.appointmentRepository.findByConfirmationLink(idAppointment)
        val recruitment : Recruitment = this.recruitmentRepository.findById(appointment.parentId).orElse(null)
        val schedule = recruitment.schedules.find { it.id == idSchedule }
        val block = schedule?.blocks?.find { it.id == idBlock }
        block?.candidate = appointment.candidate
        block?.free = false
        appointment.scheduleBlock = schedule?.blocks?.find { it.id == idBlock }
        appointment.confirmed = true;
        this.appointmentRepository.save(appointment)
        return "ok"
    }
}