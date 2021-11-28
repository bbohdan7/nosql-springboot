package com.zbogdan.app.appchik.repos

import com.zbogdan.app.appchik.models.mongo.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserMongoRepo : MongoRepository<User, String> {
    fun findByName(name: String): List<User>
    fun findByEmail(email: String): List<User>
}