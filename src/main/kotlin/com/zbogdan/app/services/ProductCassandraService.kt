package com.zbogdan.app.services

import com.datastax.oss.driver.api.querybuilder.QueryBuilder
import com.datastax.oss.driver.api.querybuilder.select.Select
import com.github.javafaker.Faker
import com.zbogdan.app.components.ProductCassandraComponent
import com.zbogdan.app.models.cassandra.Product
import com.zbogdan.app.repos.ProductCassandraRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.cassandra.core.CassandraOperations
import org.springframework.data.cassandra.core.CassandraTemplate
import org.springframework.data.cassandra.core.cql.QueryOptions
import org.springframework.data.cassandra.core.select
import org.springframework.stereotype.Service
import java.util.*
import javax.annotation.PostConstruct
import kotlin.random.Random

@Service
class ProductCassandraService {

    @Autowired
    private lateinit var comp: ProductCassandraComponent

    @Autowired
    private lateinit var cassandraTemplate: CassandraOperations

    fun fetchAll(): List<Product> = comp.findAll()

    fun fetchByCriteria() {


    }

    fun seedKeyspace(amount: Int = 5): Unit {
        var i = 0
        repeat(amount) {
            comp.create(
                Product(
                    id = ++i,
                    name = Faker().commerce().productName(),
                    price = Random.nextDouble(99.99, 1999.99).toFloat(),
                    created_At = Date()
                )
            )
            println("Cassandra written to")
        }
    }
}