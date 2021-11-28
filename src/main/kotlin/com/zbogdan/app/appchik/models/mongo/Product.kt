package com.zbogdan.app.appchik.models.mongo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("products")
data class Product(
    @Id
    var id: String?,
    var name: String?,
    var price: Float?,
    var available: Boolean?
)