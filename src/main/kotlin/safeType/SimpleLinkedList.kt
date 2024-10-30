package ru.af3412.safeType

class SimpleLinkedList<T> : Iterable<T>, ListIterator<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var currentNode: Node<T>? = null
    private var index: Int = 0

    fun add(value: T) {
        val newNode = Node(value)
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            tail = newNode
        }
    }

    override fun iterator(): Iterator<T> {
        return LinkedIt()
    }

    inner class LinkedIt : Iterator<T> {
        private var current: Node<T>? = head

        override fun hasNext(): Boolean = current != null

        override fun next(): T {
            if (!hasNext()) {
                throw NoSuchElementException()
            }
            val value = current!!.value
            current = current!!.next
            return value
        }
    }

    class Node<K>(val value: K, var next: Node<K>? = null)

    override fun hasNext(): Boolean = currentNode != null && currentNode!!.next != null

    override fun hasPrevious(): Boolean = index > 0

    override fun next(): T {
        if (!hasNext()) {
            throw NoSuchElementException()
        }
        currentNode = if (currentNode == null) head
                    else currentNode!!.next
        index++
        return currentNode!!.value
    }

    override fun nextIndex(): Int {
        return index
    }

    override fun previous(): T {
        if (!hasPrevious()) {
            throw NoSuchElementException()
        }
        currentNode = if (currentNode == null) tail else findPrevious(currentNode!!)
        index--
        return currentNode!!.value
    }

    private fun findPrevious(node: Node<T>): Node<T>? {
        var current = head
        while (current != null && current.next != node) {
            current = current.next
        }
        return current
    }

    override fun previousIndex(): Int {
        return index - 1
    }
}


fun main() {
    val list = SimpleLinkedList<String>()
    list.add("1")
    list.add("2")
    list.add("3")
    list.add("4")
    for (value in list) {
        println(value)
    }
}