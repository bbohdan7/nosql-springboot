package com.zbogdan.app.models.mysql

import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "products")
data class Product(
    @Id
    @Column(name = "id")
    var id: Int? = null,

    @Column(name = "name")
    var name: String? = null,

    @Column(name = "price")
    var price: Float? = null,

    @Column(name = "available")
    var available: Boolean? = null,

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    var createdAt: Date? = null
) : Serializable