package com.zbogdan.app.repos

import com.zbogdan.app.models.cassandra.Product
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductCassandraRepo : CassandraRepository<Product, Int>