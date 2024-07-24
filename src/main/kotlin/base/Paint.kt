package ru.af3412.base

fun main() {
    drawX(3)
}

fun drawX(size: Int) {
    var carriage = 0
    for (countY in 0 until size) {
        for (countX in 0 until size)
            print(
                if (countX == carriage || (size - 1 - countX == carriage)) "X" else " "
            )
        carriage++
        println()
    }
}