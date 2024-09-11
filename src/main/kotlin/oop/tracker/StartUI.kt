package ru.af3412.oop.tracker

class StartUI private constructor() {

    companion object {

        private val tracker: Tracker = Tracker()

        fun init() {
            println("Starting Tracker UI...")
            var select: String
            do {
                println("Трекер\n" +
                        "1. Добавить заявку\n" +
                        "2. Посмотреть все заявки\n" +
                        "3. Выход")
                print("Выберите пункт меню(введите цифру): ")
                select = readln()
                when (select) {
                    "1" -> addItem()
                    "2" -> println(getAllItems())
                }
            } while ("3" != select)
            println("Exit from Tracker")
        }

        private fun addItem() {
            print("Введите имя заявки: ")
            val name = readln()
            print("Введите описание заявки: ")
            val description = readln()
            println("Adding item: $name, description: $description")
            tracker.createItem(name, description)
        }

        private fun getAllItems() = tracker.getItems()
    }

}