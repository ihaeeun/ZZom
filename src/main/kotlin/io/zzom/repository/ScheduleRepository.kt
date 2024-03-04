package io.zzom.repository

import io.zzom.entity.Schedule
import org.springframework.data.jpa.repository.JpaRepository
import java.sql.Time

interface ScheduleRepository : JpaRepository<Schedule, Long> {
    fun findAllByDayAndAlertTime(day: String, alertTime: Time): List<Schedule>

    fun findAllByDayAndAlertTimeBetween(day: String, alertTimeStart: Time, alertTimeEnd: Time): List<Schedule>

    fun findAllByHabitId(habitId: Long): List<Schedule>
}