package ru.af3412.lambda

import java.util.Date

data class Address(val street: String, val city: String)

data class Campaing(val name: String, val address: Address, val created: Date)

fun campToString(campaings: List<Campaing>): List<String> {
    return campaings.map { it.toString() }
}
