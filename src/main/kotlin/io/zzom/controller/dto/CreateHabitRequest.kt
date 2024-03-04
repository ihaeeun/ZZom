package io.zzom.controller.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.DayOfWeek

data class CreateHabitRequest(
    val userId: Long, val habit: String, val days: HashSet<DayOfWeek>,
    @JsonFormat(pattern = "HH:mm:ss") val alertTime: String
)