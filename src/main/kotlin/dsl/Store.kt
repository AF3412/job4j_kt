package ru.af3412.dsl

data class Item(val name: String)

interface Store<T> {
    fun save(model: T): T
}

class ItemStore: Store<Item> {
    override fun save(model: Item): Item {
        println("saving $model")
        return model
    }
}

fun Item.save(): Item {
    val store = ItemStore()
    store.save(this)
    return this
}

fun main() {
    val item = Item("Value")
    item.save()
}