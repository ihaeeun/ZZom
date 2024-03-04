package io.zzom.controller.dto

import java.time.DayOfWeek

data class HabitResponse(val id: Long, val habit: String, val day: Set<DayOfWeek>, val alertTime: String)