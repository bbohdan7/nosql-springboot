package com.zbogdan.app.repos

import com.zbogdan.app.models.mongo.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserMongoRepo : MongoRepository<User, String> {
    fun findByName(name: String): List<User>
    fun findByEmail(email: String): List<User>
}