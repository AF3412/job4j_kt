package base

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import ru.af3412.base.defragment

class ArrTest {

    @Test
    fun defragTest1() {
        val names = arrayOfNulls<String>(1)
        names[0] = "0"

        defragment(names)

        assertThat(names[0]).isEqualTo("0")
    }

    @Test
    fun defragTest2() {
        val names = arrayOfNulls<String>(2)
        names[0] = "0"

        defragment(names)

        assertThat(names[0]).isEqualTo("0")
        assertThat(names[1]).isNull()
    }

    @Test
    fun defragTest3() {
        val names = arrayOfNulls<String>(3)
        names[2] = "0"

        defragment(names)

        assertThat(names[0]).isEqualTo("0")
        assertThat(names[1]).isNull()
        assertThat(names[2]).isNull()
    }

    @Test
    fun defragTest4() {
        val names = arrayOfNulls<String>(5)
        names[2] = "0"
        names[3] = "0"
        names[4] = "0"

        defragment(names)

        assertThat(names[0]).isEqualTo("0")
        assertThat(names[1]).isEqualTo("0")
        assertThat(names[2]).isEqualTo("0")
        assertThat(names[3]).isNull()
        assertThat(names[4]).isNull()
    }

    @Test
    fun defragTest5() {
        val names = arrayOfNulls<String>(5)

        defragment(names)

        assertThat(names[0]).isNull()
        assertThat(names[1]).isNull()
        assertThat(names[2]).isNull()
        assertThat(names[3]).isNull()
        assertThat(names[4]).isNull()
    }

    @Test
    fun defragTest6() {
        val names = arrayOfNulls<String>(6)
        names[0] = "0"
        names[2] = "0"
        names[4] = "0"

        defragment(names)

        assertThat(names[0]).isEqualTo("0")
        assertThat(names[1]).isEqualTo("0")
        assertThat(names[2]).isEqualTo("0")
        assertThat(names[3]).isNull()
        assertThat(names[4]).isNull()
        assertThat(names[5]).isNull()
    }

    @Test
    fun defragTest7() {
        val names = arrayOfNulls<String>(6)
        names[1] = "0"
        names[3] = "0"
        names[5] = "0"

        defragment(names)

        assertThat(names[0]).isEqualTo("0")
        assertThat(names[1]).isEqualTo("0")
        assertThat(names[2]).isEqualTo("0")
        assertThat(names[3]).isNull()
        assertThat(names[4]).isNull()
        assertThat(names[5]).isNull()
    }
}