package base

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import ru.af3412.base.*

class CalcTest {

    @Test
    fun when1Plus1() {
        assertThat(add(1, 1)).isEqualTo(2)
    }

    @Test
    fun when1Min1() {
        assertThat(substract(1, 1)).isEqualTo(0)
    }

    @Test
    fun when2Multiply2() {
        assertThat(multiply(2, 2)).isEqualTo(4)
    }

    @Test
    fun when9Divide3() {
        assertThat(divide(9, 3)).isEqualTo(3)
    }

    @Test
    fun whenMax2Compare() {
        assertThat(max2(3,2)).isEqualTo(3)
    }

    @Test
    fun whenMax3Compare() {
        assertThat(max3(4,3, 2)).isEqualTo(4)
    }
}