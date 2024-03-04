package io.zzom.service

import io.zzom.controller.dto.CreateHabitRequest
import io.zzom.controller.dto.HabitResponse
import io.zzom.entity.Habit
import io.zzom.entity.Schedule
import io.zzom.repository.HabitRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.time.DayOfWeek
import java.util.stream.Collectors

@Service
class HabitService(private val habitRepository: HabitRepository, private val scheduleService: ScheduleService) {

    @Transactional
    fun createHabit(request: CreateHabitRequest): HabitResponse {
        var habit = this.habitRepository.save(Habit.of(request))
        var schedules = request.days.stream().map { day -> Schedule.of(habit.id, day, request.alertTime) }.toList()
        this.scheduleService.saveSchedules(schedules)

        return HabitResponse(habit.id, habit.habit, request.days, request.alertTime)
    }

    fun getHabit(habitId: Long): HabitResponse {
        var habit = this.habitRepository.findById(habitId).orElseThrow()
        var schedules = this.scheduleService.getSchedules(habitId)

        var days = schedules.stream().map { schedule -> DayOfWeek.valueOf(schedule.day) }.collect(Collectors.toSet())
        return HabitResponse(habit.id, habit.habit, days, schedules.get(0).alertTime.toString())
    }

    fun getAllByUserId(userId: Long): List<Habit> {
        return this.habitRepository.findAllByUserId(userId)
    }
}