package ru.af3412.dsl

class Calc {

    fun main() {
        val map = hashMapOf(
            0 to "zero",
            1 to "one",
            2 to "two")
        print(map)
    }

    fun sum(first: Int, second: Int) = first + second

}