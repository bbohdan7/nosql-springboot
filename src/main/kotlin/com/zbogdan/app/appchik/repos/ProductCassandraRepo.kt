package com.zbogdan.app.appchik.repos

import com.zbogdan.app.appchik.models.cassandra.Product
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductCassandraRepo : CassandraRepository<Product, Int>