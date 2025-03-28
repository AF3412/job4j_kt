package ru.af3412.dsl

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.boot.MetadataSources
import org.hibernate.boot.registry.StandardServiceRegistryBuilder

fun main() {
    val registry = StandardServiceRegistryBuilder().configure().build()
    try {
        val sf = MetadataSources(registry).buildMetadata().buildSessionFactory()
        val item = create(Item(id = 1, name = "Learn Hibernate"), sf)
        println(item)
        item.name = "Learn Hibernate 5."
        update(item, sf)
        println(item)
        val rsl = findById(item.id, sf)
        println(rsl)
        delete(rsl.id, sf)
        val list = findAll(sf)
        for (it in list) {
            println(it)
        }
    } finally {
        StandardServiceRegistryBuilder.destroy(registry)
    }
}

fun <T> tx(sf: SessionFactory, block: (session: Session) -> T): T {
    val session = sf.openSession()
    session.beginTransaction()
    val model = block(session)
    session.transaction.commit()
    session.close()
    return model
}

fun <T> SessionFactory.tx2(block: Session.() -> T): T {
    val session = openSession()
    session.beginTransaction()
    val model = session.block()
    session.transaction.commit()
    session.close()
    return model
}

fun create(item: Item, sf: SessionFactory): Item {
    val session = sf.openSession()
    session.beginTransaction()
    session.save(item)
    session.transaction.commit()
    session.close()
    return item
}

fun update(item: Item?, sf: SessionFactory) {
    val session = sf.openSession()
    session.beginTransaction()
    session.update(item)
    session.transaction.commit()
    session.close()
}

fun delete(id: Int, sf: SessionFactory) {
    val session = sf.openSession()
    session.beginTransaction()
    val item = Item()
    item.id = id
    session.delete(item)
    session.transaction.commit()
    session.close()
}

fun findAll(sf: SessionFactory): List<Item> {
    val session = sf.openSession()
    session.beginTransaction()
    val result = session.createQuery("from ru.af3412.dsl.Item").list() as List<Item>
    session.transaction.commit()
    session.close()
    return result
}

fun findById(id: Int?, sf: SessionFactory): Item {
    val session = sf.openSession()
    session.beginTransaction()
    val result = session.get(Item::class.java, id)
    session.transaction.commit()
    session.close()
    return result
}
