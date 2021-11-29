package com.zbogdan.app.repos

import com.zbogdan.app.models.mongo.Product
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductMongoRepo : MongoRepository<Product, String> {
    fun findByAvailable(available: Boolean): List<Product>
}