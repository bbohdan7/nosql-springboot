package com.zbogdan.app.appchik.services

import com.github.javafaker.Faker
import com.zbogdan.app.appchik.components.UserMongoComponent
import com.zbogdan.app.appchik.models.mongo.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class UserMongoService {

    @Autowired
    private lateinit var component: UserMongoComponent

    suspend fun insert(): Unit = repeat(200) {
        println("Inserting...")
        component.insert(
            User(
                id = Faker().number().randomDigit().toString(),
                name = Faker().funnyName().name(),
                email = Faker().name().lastName() + "@" + Faker().company().url()
            )
        )
        delay(1500L)
    }

    suspend fun doingSomeBackground(): Unit = repeat(150) {
        println("Found: " + component.findAll().stream().map(User::id).forEach(System.out::println))
        delay(1000L)
    }

    fun init(): Unit = println("All of the mongo's users: ${component.findAll()}").apply {
        println("Trying to insert a new document...")

        runBlocking {
            launch {
                doingSomeBackground()
            }
        }

        runBlocking {
            launch {
                insert()
            }
        }
    }
}