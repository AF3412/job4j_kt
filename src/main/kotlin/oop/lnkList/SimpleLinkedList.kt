package ru.af3412.oop.lnkList

class SimpleLinkedList<T> : Iterable<T> {

    class Node<K>(val value: K, var next: Node<K>? = null)

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    var size: Int = 0

    inner class LinkedIt : Iterator<T> {
        private var current = head

        override fun hasNext(): Boolean {
            return current != null
        }

        override fun next(): T {
            if (!hasNext()) {
                throw NoSuchElementException()
            }
            val value = current?.value ?: throw NoSuchElementException()
            current = current?.next
            return value
        }

    }

    override fun iterator(): Iterator<T> {
        return LinkedIt()
    }

    fun add(value: T) {
        val newNode = Node(value)
        if (tail != null) {
            tail?.next = newNode
        } else {
            head = newNode
        }
        tail = newNode
        size++
    }

}

fun main() {
    val list = SimpleLinkedList<String>()
    list.add("node")
    list.add("node2")
    list.add("node3")

    for (value in list) {
        println(value)
    }
}