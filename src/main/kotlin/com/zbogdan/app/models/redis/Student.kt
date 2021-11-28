package com.zbogdan.app.models.redis

import org.springframework.data.redis.core.RedisHash

@RedisHash("student")
data class Student(
    var id: Int?,
    var name: String?,
    var email: String?,
    var course: Int?
)