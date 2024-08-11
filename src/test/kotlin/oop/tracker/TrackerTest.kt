package oop.tracker

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import ru.af3412.oop.tracker.Tracker

class TrackerTest {

    @Test
    fun testCreateTracker() {
        val tracker = Tracker()
        assertEquals(0, tracker.getItems().size)
    }

    @Test
    fun testAddItems() {
        val tracker = Tracker()
        tracker.createItem("first item", "description item")

        val item = tracker.getItems().get(0)

        assertEquals(1, tracker.getItems().size)
        assertEquals("first item", item?.name)
        assertEquals("description item", item?.description)
    }

    @Test
    fun testAddComments() {
        val tracker = Tracker()
        val item = tracker.createItem("first item", "description item")

        tracker.addComment(item, "first comment")
        tracker.addComment(item, "second comment")

        assertEquals("first comment", tracker.getItems()[0]?.comments?.get(0))
        assertEquals("second comment", tracker.getItems()[0]?.comments?.get(1))
    }

    @Test
    fun testRemoveItem() {
        val tracker = Tracker()
        val item = tracker.createItem("first item", "description item")
        tracker.createItem("second item", "description for second item")

        assertEquals(2, tracker.getItems().size)

        tracker.deleteItem(item)

        assertEquals(1, tracker.getItems().size)
        assertEquals("second item", tracker.getItems()[0]?.name)
    }

    @Test
    fun nullItemWithoutExceptionTest() {
        val tracker = Tracker()
        val item = tracker.getItemById(0)

        assertNull(item)
        assertNull(item?.name)
        assertNull(item?.comments?.get(0))
    }

}