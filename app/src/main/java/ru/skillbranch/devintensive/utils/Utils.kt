package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        //TODO fix me!!!
        val parts: List<String>? = fullName?.split(" ")

        val fistName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

//        return Pair(fistName, lastName)
        return fistName to lastName
    }

    fun transliteration(payload: String?, divider: String = ""): String {
        TODO("Not yet implemented")
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        TODO("Not yet implemented")
    }
}