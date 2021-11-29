package com.zbogdan.app.repos

import com.zbogdan.app.models.mysql.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductMysqlRepo : CrudRepository<Product, Int>