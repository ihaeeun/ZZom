package io.zzom.controller

import io.zzom.controller.dto.CreateHabitRequest
import io.zzom.entity.Habit
import io.zzom.service.HabitService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/habit")
class HabitController(private val habitService: HabitService) {

    @PostMapping
    fun createHabit(@RequestBody request: CreateHabitRequest): Habit {
        return this.habitService.createHabit(Habit.of(request))
    }

}