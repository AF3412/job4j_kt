package ru.af3412.oop

open class Profession (name: String) {
    open fun getName(): String = "profession"
    open fun action(): String = "do professional work"
}

class Driver(private val name: String, private val category: String) : Profession(name) {
    override fun toString(): String {
        return "Driver(name='$name', category='$category')"
    }

    override fun getName() = "Driver $name"
    override fun action(): String {
        return super.action() + " drive"
    }
}

class Teacher(private val name: String, private val school: String) : Profession(name) {
    override fun toString(): String {
        return "Teacher(name='$name', school='$school')"
    }
    override fun getName() = "Teacher $name"
    override fun action(): String {
        return super.action() + " teach"
    }
}

class Programmer(private val name: String, private val language: String, private val experience: Int) : Profession(name) {
    override fun toString(): String {
        return "Programmer(name='$name', language='$language', experience=$experience)"
    }
    override fun getName() = "Programmer $name"
    override fun action(): String {
        return super.action() + " write soft"
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
    println(profession.getName())
    println(profession.action())
}