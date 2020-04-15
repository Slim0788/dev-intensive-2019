package ru.skillbranch.devintensive.utils

import java.util.*

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {

        return when (val string = fullName?.trim()) {
            null, "" -> null to null
            else -> {
                val parts: List<String> = string.split(" ")

                val fistName = parts.getOrNull(0)
                val lastName = parts.getOrNull(1)

                return fistName to lastName
            }
        }
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var result = ""
        if (firstName?.trim() != "") {
            result += firstName?.trim()?.substring(0, 1) ?: ""
        }
        if (lastName?.trim() != "") {
            result += lastName?.trim()?.substring(0, 1) ?: ""
        }

        return if (result.trim() == "") {
            null
        } else {
            result.toUpperCase(Locale.ROOT)
        }
    }

    fun transliteration(payload: String, divider: String = " ") =
        payload.replace(Regex("[а-я А-Я]")) {
            when (it.value) {
                "а" -> "a"
                "б" -> "b"
                "в" -> "v"
                "г" -> "g"
                "д" -> "d"
                "е" -> "e"
                "ё" -> "e"
                "ж" -> "zh"
                "з" -> "z"
                "и" -> "i"
                "й" -> "i"
                "к" -> "k"
                "л" -> "l"
                "м" -> "m"
                "н" -> "n"
                "о" -> "o"
                "п" -> "p"
                "р" -> "r"
                "с" -> "s"
                "т" -> "t"
                "у" -> "u"
                "ф" -> "f"
                "х" -> "h"
                "ц" -> "c"
                "ч" -> "ch"
                "ш" -> "sh"
                "щ" -> "sh'"
                "ъ" -> ""
                "ы" -> "i"
                "ь" -> ""
                "э" -> "e"
                "ю" -> "yu"
                "я" -> "ya"
                "А" -> "A"
                "Б" -> "B"
                "В" -> "V"
                "Г" -> "G"
                "Д" -> "D"
                "Е" -> "E"
                "Ё" -> "E"
                "Ж" -> "Zh"
                "З" -> "Z"
                "И" -> "I"
                "Й" -> "I"
                "К" -> "K"
                "Л" -> "L"
                "М" -> "M"
                "Н" -> "N"
                "О" -> "O"
                "П" -> "P"
                "Р" -> "R"
                "С" -> "S"
                "Т" -> "T"
                "У" -> "U"
                "Ф" -> "F"
                "Х" -> "H"
                "Ц" -> "C"
                "Ч" -> "Ch"
                "Ш" -> "Sh"
                "Щ" -> "Sh'"
                "Ъ" -> ""
                "Ы" -> "I"
                "Ь" -> ""
                "Э" -> "E"
                "Ю" -> "Yu"
                "Я" -> "Ya"
                " " -> divider
                else -> it.value
            }
        }
}