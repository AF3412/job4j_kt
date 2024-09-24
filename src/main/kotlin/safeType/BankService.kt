package ru.af3412.safeType

class BankService {

    private val users: HashMap<User, ArrayList<Account>> = HashMap()

    fun addUser(user: User) {
        users.putIfAbsent(user, ArrayList())
    }

    fun findByRequisite(passport: String, requisite: String): Account? {
        val user = findByPassport(passport) ?: return null
        return users[user]?.stream()?.filter { it.requisite == requisite }
            ?.findFirst()
            ?.orElse(null)
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
    var user = bank.findByPassport("3211")
    System.out.println(user?.userName)
    user = bank.findByPassport("321")
    System.out.println(user?.userName)
}
