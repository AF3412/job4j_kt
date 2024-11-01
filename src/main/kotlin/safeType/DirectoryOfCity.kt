package ru.af3412.safeType

class DirectoryOfCity {

    val cities : List<String> by lazy { loadCities() }

    private fun loadCities(): List<String> {
        return listOf("Moscow", "New York", "Paris", "London")
    }
}

fun main() {
    val directoryOfCity = DirectoryOfCity()
    directoryOfCity.cities.forEach(::println)
}