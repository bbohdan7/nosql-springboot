package com.zbogdan.app.repos

import com.zbogdan.app.models.couchbase.Product
import org.springframework.data.couchbase.repository.CouchbaseRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductCouchbaseRepo : CouchbaseRepository<Product, Int>