package lambda

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.af3412.lambda.Account

class AccountTest {


    @Test
    fun testAccount() {
        val account = Account("Ivan", 100)
        val account2 = Account("Ivan", 0)
        val account3 = Account("Ivan", 1)
        val account4 = Account("Ivan", -1)
        val account5 = Account("Petr", 100)
        val account6 = Account("Pavel", -1)

        val result = listOf(account, account2, account3, account4, account5, account6)
            .filter { it.name == "Ivan" && it.balance > 0 }

        assertEquals(2, result.size)

    }

}