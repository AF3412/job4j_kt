package ru.af3412.lambda

fun main() {
    val max = { x: Int, y: Int -> if (x > y) x else y }
    println(max(1, 2))
    val inc = { x: Int -> x + 1}
    println(inc(2))
    val dec = { x: Int -> x - 1}
    println(dec(2))
    val double = { x: Int -> x * x}
    println(double(2))
}