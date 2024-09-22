package com.soujunior.petjournal.ui.util

import java.util.Date
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

fun calculateAge(dateString: String): Pair<Int, Int> {
    val birthDate = Calendar.getInstance().apply {
        timeInMillis = convertToTimestamp(dateString)
    }
    val currentDate = Calendar.getInstance()

    var years = currentDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR)
    var months = currentDate.get(Calendar.MONTH) - birthDate.get(Calendar.MONTH)

    if (months < 0) {
        months += 12
        years -= 1
    }

    return Pair(years, months)
}

fun formatAge(age: Pair<Int, Int>): String {
    val (years, months) = age
    return when {
        years == 0 -> "$months ${if (months == 1) "mês" else "meses"}"
        months == 0 -> "$years ${if (years == 1) "ano" else "anos"}"
        else -> "$years ${if (years == 1) "ano" else "anos"} e $months meses"
    }
}

private fun convertToTimestamp(dateString: String): Long {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.getDefault())
    dateFormat.timeZone = TimeZone.getTimeZone("UTC")
    val date: Date? = dateFormat.parse(dateString)
    return date?.time ?: throw IllegalArgumentException("Invalid date format")
}