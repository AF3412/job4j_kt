package ru.af3412.oop.tracker

interface Action {
    fun init()
    fun addItem(tracker: Tracker)
    fun getAllItems(tracker: Tracker) : ArrayList<Item>
}

class StartUI : Action  {

    override fun init() {
        val tracker = Tracker()
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
                "1" -> addItem(tracker)
                "2" -> println(getAllItems(tracker))
            }
        } while ("3" != select)
        println("Exit from Tracker")
    }

    override fun addItem(tracker: Tracker) {
        print("Введите имя заявки: ")
        val name = readln()
        print("Введите описание заявки: ")
        val description = readln()
        println("Adding item: $name, description: $description")
        tracker.createItem(name, description)
    }

    override fun getAllItems(tracker: Tracker)= tracker.getItems()

}