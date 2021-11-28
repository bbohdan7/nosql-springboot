package com.zbogdan.app.services

import com.github.javafaker.Faker
import com.zbogdan.app.components.StudentRedisComponent
import com.zbogdan.app.models.redis.Student
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct
import kotlin.random.Random

@Service
class StudentRedisService {

    @Autowired
    private lateinit var comp: StudentRedisComponent

    @PostConstruct
    fun init(): Unit {
        seedingHash(5)
        println("Trying to fetch all of the Students from Redis storage...")
        comp.findAll().forEach(System.out::println)
    }

    private fun seedingHash(amount: Int = 5): Unit {
        var i = 0
        repeat(5) {
            comp.create(
                Student(
                    id = ++i,
                    name = Faker().name().firstName(),
                    email = Faker().name().firstName() + "@" + Faker().company().url(),
                    course = Random.nextInt(1, 5)
                )
            )
            println("Added")
        }
    }
}