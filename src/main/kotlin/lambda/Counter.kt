package ru.af3412.lambda


fun count(list: ArrayList<Int>): Int {

    return list
        .stream()
        .filter { value -> value > 0 }
        .map { value -> value + 1 }
        .toList()
        .sum()
}


fun main() {
    println(count(arrayListOf(1, 2, 3, 4, -1)))
}