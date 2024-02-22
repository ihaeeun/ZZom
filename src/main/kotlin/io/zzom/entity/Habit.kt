package io.zzom.entity

import io.zzom.controller.dto.CreateHabitRequest
import jakarta.persistence.*
import java.time.DayOfWeek

@Entity
class Habit(userId: Long, habit: String, day: HashSet<DayOfWeek>?, alertTime: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    var id: Long? = null

    @Column(nullable = false)
    var habit: String = habit

    @Column(nullable = false)
    var userId: Long = userId


    @Column(nullable = true)
    var day: HashSet<DayOfWeek>? = day

    @Column(nullable = true)
    var alertTime: String? = ""

    companion object {
        fun of(request: CreateHabitRequest): Habit {
            return Habit(request.userId, request.habit, request.day, request.alertTime);
        }
    }
}