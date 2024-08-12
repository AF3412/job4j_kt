package ru.af3412.oop.tracker

import java.time.LocalDateTime

class Tracker(
    private val items: ArrayList<Item> = ArrayList(),
    private var nexId: Int = 0
) {

    fun createItem(name: String, description: String): Item {
        val newItem = Item(
            id = generateId(),
            name = name,
            description = description,
            positionComment = 0,
            dateCreation = LocalDateTime.now()
        )
        items.add(newItem)
        return newItem
    }

    fun getItems(): ArrayList<Item> {
        return items
    }

    fun getItemById(id: Int): Item? {
        return items.find { it.id == id }
    }

    fun deleteItem(item: Item) {
        items.remove(item)
    }

    fun addComment(item: Item, newComment: String) {
        item.addComment(newComment)
    }

    private fun generateId(): Int {
        return nexId++
    }


}