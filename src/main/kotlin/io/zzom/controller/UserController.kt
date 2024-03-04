package io.zzom.controller

import io.zzom.controller.dto.SignUpRequest
import io.zzom.entity.Habit
import io.zzom.entity.User
import io.zzom.service.ScheduleService
import io.zzom.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService, private val scheduleService: ScheduleService) {

    @PostMapping
    fun signUp(@RequestBody request: SignUpRequest): User {
        return this.userService.signUp(User.of(request))
    }

    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: Long): User {
        return this.userService.getUserInfo(userId)
    }

    @GetMapping("/{userId}/habits")
    fun getHabitList(@PathVariable userId: Long): List<Habit> {
        return this.userService.getAllHabits(userId)
    }

    @GetMapping
    fun test() {
        return scheduleService.alert()
    }
}