package com.zbogdan.app.appchik.models.mongo

import org.springframework.data.mongodb.core.mapping.Document

@Document("users")
data class User(
    var id: String?,
    var name: String?,
    var email: String?
)