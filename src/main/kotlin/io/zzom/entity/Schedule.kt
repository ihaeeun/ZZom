package io.zzom.entity

import jakarta.persistence.*
import java.sql.Time
import java.time.DayOfWeek
import java.time.format.TextStyle
import java.util.*

@Entity
class Schedule(habitId: Long, day: String, alertTime: Time) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @Column
    var id: Long = 0

    @Column(nullable = false)
    var habitId: Long = habitId

    @Column(nullable = false)
    var day: String = day

    @Column(nullable = false)
    var alertTime: Time = alertTime

    companion object {
        fun of(habitId: Long, day: DayOfWeek, alertTime: String): Schedule {
            return Schedule(
                habitId,
                day.getDisplayName(TextStyle.FULL, Locale.ENGLISH).uppercase(),
                Time.valueOf(alertTime)
            )
        }
    }

    override fun toString(): String {
        return "Schedule(id=$id, habitId=$habitId, day='$day', alertTime=$alertTime)"
    }


}