package io.zzom.entity

import io.zzom.controller.dto.CreateHabitRequest
import jakarta.persistence.*

@Entity
class Habit(userId: Long, habit: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @Column
    var id: Long = 0

    @Column(nullable = false)
    var habit: String = habit

    @Column(nullable = false)
    var userId: Long = userId

    companion object {
        fun of(request: CreateHabitRequest): Habit {
            return Habit(request.userId, request.habit);
        }
    }
}