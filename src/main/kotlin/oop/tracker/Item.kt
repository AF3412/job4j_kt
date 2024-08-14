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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Item

        return id == other.id
    }

    override fun hashCode(): Int {
        return id
    }
}