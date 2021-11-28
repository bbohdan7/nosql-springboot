package com.zbogdan.app.models.cassandra

import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.util.*

@Table("products")
data class Product(

    @PrimaryKey
    @Column("id")
    var id: Int?,

    @Column("name")
    var name: String?,

    @Column("price")
    var price: Float?,

    @Column("created_at")
    var created_At: Date?
)