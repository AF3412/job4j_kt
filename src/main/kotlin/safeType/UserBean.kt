package ru.af3412.safeType

class UserBean {
    var emails: List<String>? = null
        get() {
            if (field == null) {
                field = loadEmails()
            }
            return field!!
        }

    private fun loadEmails(): List<String> = listOf("parsentev@yandex.ru")
}

fun main() {
    val user = UserBean()
    println(user.emails)
}