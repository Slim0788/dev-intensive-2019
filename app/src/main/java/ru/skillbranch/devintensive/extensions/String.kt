package ru.skillbranch.devintensive.extensions

fun String.truncate(num: Int = 16): String {
    return if (this.trim().length < num) {
        this.trim()
    } else {
        this.substring(0, num).trim() + "..."
    }
}

fun String.stripHtml() =
    this.replace("&quot;", "\"")
        .replace("&amp;", "&")
        .replace("&lt;", "<")
        .replace("&gt", ">")
        .replace("&apos", "'")
        .replace("\\s+".toRegex(), " ")
        .replace("(<(/?[^>]+)>)".toRegex(), "")
