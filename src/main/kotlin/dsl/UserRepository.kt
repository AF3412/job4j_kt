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
    val alice = User(uniqueIdGenerator(), "Alice")
    create(alice, connection)
    printAll(connection)
    val vasya = User(1, "Vasya")
    update(vasya, connection)
    printAll(connection)
    delete(User(1, "Vasya"), connection)
    printAll(connection)
    connection.close()
}

fun <T> tx(cn: Connection, block: (statement: Statement) -> T): T {
    val statement = cn.createStatement()
    val model = block(statement)
    return model
}

fun <T> Connection.tx3(block: Statement.() -> T): T {
    val statement = createStatement()
    val model = block(statement)
    return model
}

fun createTable(connection: Connection) {
    val statement = connection.createStatement()
    statement.execute("CREATE TABLE IF NOT EXISTS persons (id INT PRIMARY KEY, name VARCHAR(255))")
    statement.close()
}

fun create(user: User, cn: Connection): User =
    tx(cn) { st ->
        st.use { statement ->
            statement.execute("INSERT INTO persons (id, name) VALUES ('${user.id}', '${user.name}')")
        }
        user
    }

fun update(user: User, cn: Connection) {
    cn.tx3 { execute("UPDATE persons SET name = '${user.name}' WHERE id = '${user.id}'") }
}

fun delete(user: User, cn: Connection) {
    cn.tx3 { execute("DELETE FROM persons WHERE id = '${user.id}'") }
}

fun printAll(connection: Connection) {
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery("SELECT * FROM persons")
    val result = ArrayList<User>()
    while (resultSet.next()) {
        result.add(User(resultSet.getInt("id"), resultSet.getString("name")))
    }
    statement.close()
    println(if (result.isEmpty()) "Empty table" else result)

}


data class User(val id: Int, val name: String)