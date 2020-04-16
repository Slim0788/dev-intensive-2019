package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()): String {
    val diff = this.time - date.time
    val pre: String
    val post: String
    if (diff < 0) {
        pre = ""
        post = " назад"
    } else {
        pre = "через "
        post = ""
    }

    return when (val absDiff = abs(diff)) {
        in -SECOND..SECOND -> "только что"
        in 1 * SECOND + 1..45 * SECOND -> pre + "несколько секунд$post"
        in 45 * SECOND + 1..75 * SECOND -> pre + "минуту$post"
        in 75 * SECOND + 1..45 * MINUTE -> pre + "${absDiff / MINUTE} ${when (((absDiff / MINUTE).toInt()) % 10) {
            1 -> "минуту"
            in 2..4 -> "минуты"
            else -> "минут"
        }
        }$post"
        in 45 * MINUTE + 1..75 * MINUTE -> "час назад"
        in 75 * MINUTE + 1..22 * HOUR -> pre + "${absDiff / HOUR} ${when (((absDiff / HOUR).toInt()) % 10) {
            1 -> "час"
            in 2..4 -> "часа"
            else -> "часов"
        }
        }$post"
        in 22 * HOUR + 1..26 * HOUR -> pre + "день$post"
        in 26 * HOUR + 1..360 * DAY -> pre + "${absDiff / DAY} ${when (((absDiff / DAY).toInt()) % 10) {
            1 -> "день"
            in 2..4 -> "дня"
            else -> "дней"
        }
        }$post"
        else -> if (diff < 0) "более года назад" else "более чем через год"
    }
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}