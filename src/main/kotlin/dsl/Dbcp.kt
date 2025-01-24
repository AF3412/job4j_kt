package ru.af3412.dsl

import org.apache.commons.dbcp2.BasicDataSource

fun main() {
//    val pool = BasicDataSource()
//    pool.setDriverClassName("org.postgres.Driver");
//    pool.setUrl("localhost");
//    pool.setUsername("postgres");
//    pool.setPassword("password");
//    pool.setMinIdle(5);
//    pool.setMaxIdle(10);
//    pool.setMaxOpenPreparedStatements(100);

    val pool = Dbcp
        .driverClassName("org.postgres.Driver")
        .url("jdbc:postgresql://localhost:5432/postgres")
        .username("postgres")
        .password("password")
        .minIdle(5)
        .maxIdle(10)
        .maxOpenPreparedStatements(100)
        .build()

    println(pool.url)
}

class Dbcp private constructor() {
    companion object Builder {
        private var driverClassName: String? = null
        private var url: String? = null
        private var username: String? = null
        private var password: String? = null
        private var minIdle: Int? = null
        private var maxIdle: Int? = null
        private var maxOpenPreparedStatements: Int? = null


        fun driverClassName(dcn: String) = apply { driverClassName = dcn }
        fun url(u: String) = apply { url = u }
        fun username(u: String) = apply { username = u }
        fun password(p: String) = apply { password = p }
        fun minIdle(min: Int) = apply { minIdle = min }
        fun maxIdle(max: Int) = apply { maxIdle = max }
        fun maxOpenPreparedStatements(mops: Int) = apply { maxOpenPreparedStatements = mops }

        fun build(): BasicDataSource {
            val pool = BasicDataSource()
            pool.driverClassName = driverClassName ?: ""
            pool.url = url ?: ""
            pool.username = username ?: ""
            pool.password = password ?: ""
            pool.minIdle = minIdle ?: 5
            pool.maxIdle = maxIdle ?: 10
            pool.maxOpenPreparedStatements = maxOpenPreparedStatements ?: 1000

            return pool
        }
    }

}