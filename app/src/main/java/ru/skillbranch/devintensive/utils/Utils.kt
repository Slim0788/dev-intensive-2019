package ru.skillbranch.devintensive.utils

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

    fun transliteration(payload: String?, divider: String = ""): String {
        TODO("Not yet implemented")
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        TODO("Not yet implemented")
    }
}