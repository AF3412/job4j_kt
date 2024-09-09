package ru.af3412.oop

open class Profession (name: String)

class Driver(private val name: String, private val category: String) : Profession(name) {
    override fun toString(): String {
        return "Driver(name='$name', category='$category')"
    }

}

class Teacher(private val name: String, private val school: String) : Profession(name) {
    override fun toString(): String {
        return "Teacher(name='$name', school='$school')"
    }
}

class Programmer(val name: String, val language: String, val experience: Int) : Profession(name) {
    override fun toString(): String {
        return "Programmer(name='$name', language='$language', experience=$experience)"
    }
}


fun main() {
    val driver = Driver("Vasya", "E")
    val teacher = Teacher("Nikolay Petrovich", "high school")
    val programmer = Programmer("John", "Kotlin", 7)

    printProfession(driver)
    printProfession(teacher)
    printProfession(programmer)
}

fun printProfession(profession: Profession) {
    println(profession)
}