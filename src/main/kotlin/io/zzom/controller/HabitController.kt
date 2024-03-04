package io.zzom.controller

import io.zzom.controller.dto.CreateHabitRequest
import io.zzom.controller.dto.HabitResponse
import io.zzom.service.HabitService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/habit")
class HabitController(private val habitService: HabitService) {

    @PostMapping
    fun createHabit(@RequestBody request: CreateHabitRequest): HabitResponse {
        return this.habitService.createHabit(request)
    }

    @GetMapping("/{habitId}")
    fun getHabit(@PathVariable habitId: Long): HabitResponse {
        return this.habitService.getHabit(habitId)
    }

}