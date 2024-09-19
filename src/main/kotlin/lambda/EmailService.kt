package ru.af3412.lambda

class EmailService {

    fun emailTo(message: Message): String {
        return with(StringBuilder()) {
            append("Subject : ").append(message.email)
            append("Body : ").append("Hello, ").append(message.email).append(" ")
            append("You win!")
        }.toString()
    }

}

data class Message(val email: String)

fun main() {
    val emailService = EmailService()
    println(emailService.emailTo(Message("email@email.com")))
}