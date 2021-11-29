package com.zbogdan.app.components

import com.zbogdan.app.models.mysql.Product
import com.zbogdan.app.repos.ProductMysqlRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductMysqlComponent {

    @Autowired
    private lateinit var repo: ProductMysqlRepo

    fun findAll(): Iterable<Product> = repo.findAll()
    fun create(product: Product): Product = repo.save(product)


}