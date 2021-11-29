package com.zbogdan.app.services

import com.github.javafaker.Faker
import com.zbogdan.app.components.ProductMysqlComponent
import com.zbogdan.app.models.mysql.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.random.Random

@Service
class ProductMysqlService {

    @Autowired
    private lateinit var comp: ProductMysqlComponent

    fun fetchAll(): Iterable<Product> = comp.findAll()

    fun seedingMysql(amount: Int): Unit {
        var i: Int = 0

        repeat(amount) {
            comp.create(
                Product(
                    id = ++i,
                    name = Faker().commerce().productName(),
                    price = Random.nextDouble(299.99, 2999.99).toFloat(),
                    available = Random.nextBoolean(),
                    createdAt = Date()
                )
            )

            println("Inserting mysql...")
        }
    }


}