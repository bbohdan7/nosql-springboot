package com.zbogdan.app.appchik.repos

import com.zbogdan.app.appchik.models.mongo.Product
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductMongoRepo : MongoRepository<Product, String> {
}