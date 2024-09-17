package lambda

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.af3412.lambda.Address
import ru.af3412.lambda.Campaing
import ru.af3412.lambda.campToString
import java.time.Instant
import java.util.Date

class CampaingKtTest {

    @Test
    fun campTest() {
        val campaings: List<Campaing> = listOf(
            Campaing("Goldman", Address("5th avenue", "New York"), Date.from(Instant.now())),
            Campaing("Best Buy", Address("Lincoln str", "Washington"), Date.from(Instant.now())),
            Campaing("Tesla", Address("New Mexico", "Mexico"), Date.from(Instant.now()))
        )

        val result = campToString(campaings)

        assertEquals(3, result.size)
        println(result)
    }
}