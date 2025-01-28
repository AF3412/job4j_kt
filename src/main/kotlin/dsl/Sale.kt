package ru.af3412.dsl

data class Sale(
    val productName: String,
    val category: String,
    val quantitySold: Int,
    val totalRevenue: Double
)

// Фильтрация по категории
fun filterByCategory(sales: List<Sale>, category: String): List<Sale> {
    return sales.filter { it.category == category }
}

// Расчет общей выручки
fun calculateTotalRevenue(sales: List<Sale>): Double {
    return sales.sumOf { sale -> sale.totalRevenue }
}

// Поиск самых продаваемых продуктов
fun topSellingProducts(sales: List<Sale>, topN: Int): List<Sale> {
    return sales.sortedBy { sale -> sale.quantitySold }.subList(sales.size - topN, sales.size)
}

// Фильтрация по минимальной выручке
fun filterByMinRevenue(sales: List<Sale>, minRevenue: Double): List<Sale> {
    return sales.sortedBy { sale -> sale.totalRevenue }
}

// Пример комбинированной операции: фильтрация по категории -> топ-продукты -> общая выручка
fun combinedSalesAnalysis(sales: List<Sale>, category: String, topN: Int): Double {
    return calculateTotalRevenue(topSellingProducts(filterByCategory(sales, category), topN))
}

inline fun combineOperation(
    sales: List<Sale>, category: String, topN: Int, operation: (List<Sale>, String, Int) -> Double
) = operation(sales, category, topN)

fun main() {

    val sales = listOf(
        Sale("Laptop", "Electronics", 10, 5000.0),
        Sale("Smartphone", "Electronics", 20, 3000.0),
        Sale("Tablet", "Electronics", 15, 2000.0),
        Sale("Headphones", "Accessories", 50, 1500.0),
        Sale("Charger", "Accessories", 100, 1000.0)
    )

    // Пример: Фильтрация по категории, нахождение топ-2 продукта и подсчет их выручки
    val electronicsRevenue = combinedSalesAnalysis(sales, "Electronics", 2)
    println("Общая выручка от топ-2 продуктов категории 'Electronics': $electronicsRevenue")

    val test = combineOperation(
        sales,
        "Electronics",
        2
    ) { s, c, n -> calculateTotalRevenue(topSellingProducts(s.filter { sale -> sale.category === c }, n)) }

    println("Общая выручка от топ-2 продуктов категории 'Electronics' через inline функцию: $test")
}

