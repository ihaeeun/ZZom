package io.zzom.service

import io.zzom.entity.Habit
import io.zzom.repository.HabitRepository
import org.springframework.stereotype.Service

@Service
class HabitService(private val habitRepository: HabitRepository) {

    fun createHabit(habit: Habit): Habit {
        return this.habitRepository.save(habit)
    }

}