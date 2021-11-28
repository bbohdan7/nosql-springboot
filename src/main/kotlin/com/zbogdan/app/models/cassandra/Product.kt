package com.zbogdan.app.models.cassandra

import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.util.*

@Table("products")
data class Product(

    @PrimaryKey
    var id: Int?,
    var name: String?,
    var price: Float?,
    var createdAt: Date?
)