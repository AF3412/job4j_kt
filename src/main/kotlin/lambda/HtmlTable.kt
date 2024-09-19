package ru.af3412.lambda

class HtmlTable {

    fun table(row: Int, cell: Int): String {
        val table = StringBuilder()
        table.apply {
            append("<table>\n")
            for (r in 0 until row) {
                append("<row>\n")
                for (c in 0 until cell) {
                    append("<cell>")
                    append("</cell>")
                }
                append("\n</row>\n")
            }
            append("</table>")
        }
        return table.toString()
    }

}

fun main() {
    val table = HtmlTable()
    println(table.table(2, 4))
}