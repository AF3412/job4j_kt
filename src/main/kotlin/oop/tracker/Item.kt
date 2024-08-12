package ru.af3412.oop.tracker

import java.time.LocalDateTime

data class Item(
    val id: Int,
    val name: String,
    val description: String,
    val dateCreation: LocalDateTime,
    var positionComment: Int = 0,
    val comments: Array<String> = Array(10) { "" },
) {
    fun addComment(comment: String) {
        comments[positionComment++] = comment
    }
}