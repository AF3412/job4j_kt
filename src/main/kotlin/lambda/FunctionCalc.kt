package ru.af3412.lambda

fun operation(type: String): (Double, Double) -> Double {
    return when (type) {
        "add" -> { a, b -> a + b }
        "subtract" -> { a, b -> a - b }
        "multiply" -> { a, b -> a * b }
        "divide" -> { a, b -> a / b }
        else -> { _, _ -> Double.NaN }
    }
}

fun add(left: (Double, Double) -> Double, right: (Double, Double) -> Double): (Double, Double, Double, Double) -> Double {
    return { a, b, c, d -> left(a, b) + right(c, d) }
}

fun main() {
    val add = operation("add")
    println(add(5.0, 3.0)) // 8.0

    val subtract = operation("subtract")
    println(subtract(5.0, 3.0)) // 2.0

    val multiply = operation("multiply")
    println(multiply(5.0, 3.0)) // 15.0

    val divide = operation("divide")
    println(divide(5.0, 3.0)) // 1.6666...

    val unknown = operation("mod")
    println(unknown(5.0, 3.0)) // NaN

    val aggrigate = add(add, add)

    val result = aggrigate(1.0, 2.0, 3.0, 4.0) // 10.
    println(result)
}