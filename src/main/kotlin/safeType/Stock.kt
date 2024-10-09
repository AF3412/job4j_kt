package ru.af3412.safeType

import java.util.Date

class Stock (val name: String, val currency: String, val date: Date) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        if (other !is Stock) return false
        if (this.hashCode() == other.hashCode()) return true
        return false
    }

    override fun hashCode(): Int {
        var hash = name.hashCode()
        hash = hash * 31 + date.hashCode()
        hash = hash * 31 + currency.hashCode()
        return hash
    }
}