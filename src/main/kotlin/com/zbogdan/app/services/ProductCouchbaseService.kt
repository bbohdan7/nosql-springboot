package com.zbogdan.app.services

import com.github.javafaker.Faker
import com.zbogdan.app.components.ProductCouchbaseComponent
import com.zbogdan.app.models.couchbase.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class ProductCouchbaseService {

    @Autowired
    private lateinit var comp: ProductCouchbaseComponent

    @PostConstruct
    fun init(): Unit {
        seedingCouchbase()

        println("Retriving all from Couchbase server: ")
        comp.findAll().forEach(System.out::println)
    }

    private fun seedingCouchbase(amount: Int = 5): Unit {
        println("Inserting some documents into Couchbase bucket...")
        var i = 0
        repeat(amount) {
            comp.create(
                Product(
                    id = (++i).toString(),
                    name = Faker().name().firstName(),
                    email = Faker().name().firstName() + "@" + Faker().company().url()
                )
            )
            println("Couchbase inserted")
        }
    }
}