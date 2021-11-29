package com.zbogdan.app.models.mongo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("products")
data class Product(
    var name: String?,
    var price: Float?,
    var available: Boolean?
)