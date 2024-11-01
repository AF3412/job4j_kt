package ru.af3412.safeType

class DbWorker {

    private lateinit var connection: Connection

    fun init(enabled: Boolean, driverName: String) {
        connection = Connection(enabled, driverName)
    }

    fun exec(sql: String): String {
        checkAllowOperation(sql)
        return "exec($sql) with driver: ${connection.driverName}"
    }

    private fun checkAllowOperation(operation: String) {
        OPERATION.entries.forEach { o ->
            if (operation.contains(o.toString())) return
        }
        throw UnsupportedOperationException("operation not supported: $operation")
    }

}

class Connection(val enabled: Boolean, val driverName: String)

enum class OPERATION {
    INSERT, UPDATE, SELECT, DELETE
}

fun main() {
    val dbWorker = DbWorker()
    dbWorker.init(true, "Postgres Driver")
    println(dbWorker.exec("INSERT INTO table VALUES val"))
    //println(dbWorker.exec("FIND INTO table VALUES val"))

    val dbWorkerNotInit = DbWorker()
    println(dbWorkerNotInit.exec("INSERT INTO table VALUES val"))
}