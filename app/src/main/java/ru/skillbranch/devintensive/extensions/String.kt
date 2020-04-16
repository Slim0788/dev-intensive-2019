package ru.skillbranch.devintensive.extensions

fun String.truncate(length: Int = 16): String {
    return if (this.trim().length < length) {
        this.trim()
    } else {
        this.substring(0, length).trim() + "..."
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
