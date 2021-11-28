package com.zbogdan.app.appchik.components

import com.zbogdan.app.appchik.models.mongo.Product
import com.zbogdan.app.appchik.repos.ProductMongoRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductMongoComponent {

    @Autowired
    private lateinit var repo: ProductMongoRepo

    fun findAll(): List<Product> = repo.findAll()
    fun findById(id: String): Product = repo.findById(id).orElse(Product("blablabla", "Nothing", -0.999f, false))
}