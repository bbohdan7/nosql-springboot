package com.zbogdan.app.models.couchbase

import org.springframework.data.annotation.Id
import org.springframework.data.couchbase.core.mapping.Document
import org.springframework.data.couchbase.core.mapping.Field

@Document
data class Product(
    @Id var id: String?,
    @Field var name: String?,
    @Field var email: String?
)