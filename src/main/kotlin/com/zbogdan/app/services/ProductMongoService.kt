package com.zbogdan.app.services

import com.github.javafaker.Faker
import com.zbogdan.app.components.ProductMongoComponent
import com.zbogdan.app.models.mongo.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class ProductMongoService {

    @Autowired
    private lateinit var comp: ProductMongoComponent

    @Autowired
    private lateinit var mongoTemplate: MongoTemplate

    fun fetchAll(): List<Product> = comp.findAll()

    fun fetchByAvailable() = comp.findByAvailable()

    fun fetchByLike(namePattern: String, price: Float, available: Boolean): List<Product> {
        val query: Query = Query()
        query.addCriteria(Criteria.where("name").regex(namePattern)).addCriteria(Criteria.where("price").lt(price))
            .addCriteria(Criteria.where("available").`is`(available))
        return mongoTemplate.find(query, Product::class.java)
    }

    fun seedMongo(amount: Int = 5): Unit {
        var i = 0

        repeat(amount) {
            comp.create(
                Product(
                    name = Faker().commerce().productName(),
                    price = Random.nextFloat(),
                    available = Random.nextBoolean()
                )
            )
            println("Mongo inserted")
        }
    }
}