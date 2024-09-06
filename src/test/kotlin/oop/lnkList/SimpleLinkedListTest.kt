package oop.lnkList

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.af3412.oop.lnkList.SimpleLinkedList

class SimpleLinkedListTest {

    @Test
    fun testEmptyList() {
        val simpleLinkedList = SimpleLinkedList<String>()
        assertEquals(0, simpleLinkedList.size)
    }

    @Test
    fun testAddList() {
        val simpleLinkedList = SimpleLinkedList<String>()

        simpleLinkedList.add("one")

        val arrayList = ArrayList<String>()
        arrayList += simpleLinkedList

        assertEquals(1, simpleLinkedList.size)
        assertEquals("one", arrayList[0])
    }

}