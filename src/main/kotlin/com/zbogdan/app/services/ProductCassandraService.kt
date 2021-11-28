package com.zbogdan.app.services

import com.zbogdan.app.components.ProductCassandraComponent
import com.zbogdan.app.models.cassandra.Product
import com.zbogdan.app.repos.ProductCassandraRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import javax.annotation.PostConstruct

@Service
class ProductCassandraService {

    @Autowired
    private lateinit var comp: ProductCassandraComponent

    @PostConstruct
    fun init() {
        println("Trying to retrieve from Cassandra...")
        println("All Products: ${comp.findAll()}")

        println("Trying to find Cassandra data by name")
        println("Found: ${comp.findByName("MacBook Air Pro 2019")}")

        println("Trying to create new Product")

        val product = comp.create(Product(id = 4, name = "Huawei P20 Smart 2020", price = 799f, createdAt = Date()))
        println("Created: $product")
    }
}