package com.zbogdan.app.components

import com.zbogdan.app.models.couchbase.Product
import com.zbogdan.app.repos.ProductCouchbaseRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductCouchbaseComponent {

    @Autowired
    private lateinit var repo: ProductCouchbaseRepo

    fun findAll(): Iterable<Product> = repo.findAll()
    fun create(product: Product) = repo.save(product)
}