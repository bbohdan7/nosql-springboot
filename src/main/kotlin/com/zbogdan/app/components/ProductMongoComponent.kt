package com.zbogdan.app.components

import com.zbogdan.app.models.mongo.Product
import com.zbogdan.app.repos.ProductMongoRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Component

@Component
class ProductMongoComponent {

    @Autowired
    private lateinit var repo: ProductMongoRepo

    fun findAll(): List<Product> = repo.findAll()
    fun findByAvailable(): List<Product> = repo.findByAvailable(true)
    fun create(product: Product) = repo.save(product)
}