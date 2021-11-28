package com.zbogdan.app.appchik.components

import com.zbogdan.app.appchik.models.mongo.User
import com.zbogdan.app.appchik.repos.UserMongoRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserMongoComponent {

    @Autowired
    private lateinit var repo: UserMongoRepo

    fun findAll(): List<User> = repo.findAll()
    fun findByName(name: String): List<User> = repo.findByName(name)
    fun findByEmail(email: String): List<User> = repo.findByEmail(email)
    fun insert(usr: User): Boolean = repo.insert(usr).id != null
    fun delete(id: String): Unit = repo.deleteById(id)
}