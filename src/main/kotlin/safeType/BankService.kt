package ru.af3412.safeType

class BankService {

    private val users: HashMap<User, ArrayList<Account>> = HashMap()

    fun addUser(user: User) {
        users.putIfAbsent(user, ArrayList())
    }

    fun findByRequisite(passport: String, requisite: String): Account? {
        return findByPassport(passport).let { user -> users[user]?.find { it.requisite == requisite } }
    }

    fun addAccount(passport: String, account: Account) {
        val user = findByPassport(passport) ?: return
        users[user]?.add(account)
    }

    fun findByPassport(passport: String): User? {
        return users.keys.firstOrNull { it.passport == passport }
    }

    fun transferMoney(
        srcPassport: String, srcRequisite: String,
        destPassport: String, descRequisite: String, amount: Double
    ): Boolean {
        val source = findByRequisite(srcPassport, srcRequisite) ?: return false
        val dest = findByRequisite(destPassport, descRequisite) ?: return false
        source.balance -= amount
        dest.balance += amount
        return true
    }

}

data class User(val passport: String, val userName: String)
data class Account(val requisite: String, var balance: Double = 0.0)

fun main() {
    val bank = BankService()
    bank.addUser(User("321", "Petr Arsentev"))
    bank.addUser(User("123", "John Smith"))
    bank.addAccount("321", Account("321", 100.0))
    bank.addAccount("123", Account("123", 50.0))
    val user = bank.findByPassport("3211")
    println(user?.userName)

    bank.transferMoney("123", "123", "321", "321", 50.0)
    println(bank.findByRequisite("321", "321"))
    println(bank.findByRequisite("123", "123"))
}
