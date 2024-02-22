package io.zzom.controller.dto

import java.time.DayOfWeek

data class CreateHabitRequest(val userId: Long, val habit: String, val day: HashSet<DayOfWeek>, val alertTime: String) {
}