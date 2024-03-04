package io.zzom.service

import io.zzom.entity.Schedule
import io.zzom.repository.ScheduleRepository
import jakarta.transaction.Transactional
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.sql.Date
import java.sql.Time
import java.text.SimpleDateFormat
import java.time.ZonedDateTime
import java.time.format.TextStyle
import java.util.Locale

@Component
class ScheduleService(private val scheduleRepository: ScheduleRepository) {

    @Transactional
    fun saveSchedules(schedules: List<Schedule>): List<Schedule> {
        return this.scheduleRepository.saveAll(schedules)
    }

    fun getSchedules(habitId: Long): List<Schedule> {
        return this.scheduleRepository.findAllByHabitId(habitId)
    }

    @Scheduled(fixedDelay = 60000)
    fun alert(): Unit {
        var formatter = SimpleDateFormat("HH:mm:ss")
        var current = ZonedDateTime.now().withSecond(0)
        var today = current.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH).uppercase()
        var time = Time.valueOf(formatter.format(Date.from(current.toInstant())))
        var list = this.scheduleRepository.findAllByDayAndAlertTime(today, Time.valueOf(formatter.format(time)))
        println(list)
    }

}