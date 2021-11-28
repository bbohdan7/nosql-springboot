package com.zbogdan.app.components

import com.zbogdan.app.models.cassandra.Product
import com.zbogdan.app.repos.ProductCassandraRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductCassandraComponent {

    @Autowired
    private lateinit var repo: ProductCassandraRepo

    fun findAll(): List<Product> = repo.findAll()
    fun findByName(name: String): List<Product> = repo.findByName(name)
    fun create(product: Product): Product = repo.save(product)
}