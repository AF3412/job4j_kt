package ru.af3412.dsl

/*class UserRepository {
}*/

import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement
import java.util.concurrent.atomic.AtomicInteger

private var uniqueId: AtomicInteger = AtomicInteger(0)

fun uniqueIdGenerator() = uniqueId.incrementAndGet()

fun main() {
    val jdbcUrl = "jdbc:h2:mem:testdb"
    val username = "sa"
    val password = ""

    val connection = DriverManager.getConnection(jdbcUrl, username, password)
    createTable(connection)
    val user = User(uniqueIdGenerator(), "Alice")
    create(user, connection)
    printAll(connection)
    update(User(1, "Vasya"), connection)
    printAll(connection)
    delete(User(1, "Vasya"), connection)
    printAll(connection)
    connection.close()
}

fun createTable(connection: Connection) {
    val statement = connection.createStatement()
    statement.execute("CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY, name VARCHAR(255))")
    statement.close()
}

fun create(user: User, connection: Connection): User {
    val statement = connection.createStatement()
    statement.execute("INSERT INTO users (id, name) VALUES ('${user.id}', '${user.name}')")
    statement.close()
    return user
}

fun update(user: User, connection: Connection) {
    val statement = connection.createStatement()
    statement.execute("UPDATE users SET name = '${user.name}' WHERE id = '${user.id}'")
    statement.close()
}

fun delete(user: User, connection: Connection) {
    val statement = connection.createStatement()
    statement.execute("DELETE FROM users WHERE id = '${user.id}'")
    statement.close()
}

fun findById(id: Int, connection: Connection): List<User> {
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery("SELECT * FROM users WHERE id = $id")
    val users = ArrayList<User>()
    while (resultSet.next()) {
        users.add(User(resultSet.getInt("id"), resultSet.getString("name")))
    }
    statement.close()
    return users
}

fun printAll(connection: Connection) {
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery("SELECT * FROM users")
    val result = ArrayList<User>()
    while (resultSet.next()) {
        result.add(User(resultSet.getInt("id"), resultSet.getString("name")))
    }
    statement.close()
    println(if (result.isEmpty()) "Empty table" else result)

}

/*fun <T> Connection.tx(block: Statement.() -> T): T {
    val statement =
}*/

data class User(val id: Int, val name: String)