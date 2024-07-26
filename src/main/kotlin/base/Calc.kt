package ru.af3412.base

fun add(first: Int, second: Int): Int = first + second
fun substract(first: Int, second: Int): Int = first - second
fun multiply(first: Int, second: Int): Int = first * second
fun divide(first: Int, second: Int): Int = first / second

fun max2(first: Int, second: Int): Int = if (first > second) first else second

fun max3(first: Int, second: Int, third: Int): Int = max2(max2(first, second), third)

fun main(args: Array<String>) {
    println("1 + 2 = ${add(1, 1)}")
    println("1 - 1 = ${substract(1, 1)}")
    println("1 * 1 = ${multiply(1, 1)}")
    println("1 / 1 = ${divide(1, 1)}")
}