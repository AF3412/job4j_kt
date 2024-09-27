package ru.af3412.safeType

import java.time.Instant
import java.util.Date

data class Purchase(val name: String, val created: Date, val address: Address?)

data class Address(private val street: String, private val home: String, private val zip: String)

fun createHtmlTable(purchases: List<Purchase>): String {
    val tableBuilder = StringBuilder()
    tableBuilder.append("<table>\n")
    for (purchase in purchases) {
        tableBuilder
            .append("<tr>")
                .append("<td>")
                .append(purchase.name)
                .append("</td>")
                .append("<td>")
                .append(purchase.created.toString())
                .append("</td>")
                .append("<td>")
                .append(purchase.address ?: "")
                .append("</td>")
            .append("</tr>\n")
    }
    tableBuilder.append("</table>\n")
    return tableBuilder.toString()
}

fun main() {
    val purchases: List<Purchase> = listOf(
        Purchase("Milk", Date.from(Instant.now()), Address("5th Avenue", "17", "123321")),
        Purchase("Beer", Date.from(Instant.now()), null),
        Purchase("Potato", Date.from(Instant.now()), Address("5th Avenue", "17", "123321"))
    )

    println(createHtmlTable(purchases))
}