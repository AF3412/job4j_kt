package dsl

import org.junit.jupiter.api.Assertions.*
import ru.af3412.dsl.Calc
import kotlin.test.Test

class CalcTest {

    private val testSample: Calc = Calc()

    @Test
    fun testSum() {
        val expected = 42
        val notExpected = 43
        val list = listOf(expected, notExpected)

        val result = testSample.sum(40, 2)

        expected eq result
        notExpected notEq result
        list contains result
    }

    infix fun <T> T.eq(expected: T) {
        assertEquals(expected, this, "Expected $expected but was $this")
    }

    infix fun <T> T.notEq(expected: T) {
        assertNotEquals(expected, this,"Expected not equal to $expected but was $this" )
    }

    infix fun <T> List<T>.contains(value: T) {
        assertTrue(this.contains(value), "Collection does not contain $value")
    }

}