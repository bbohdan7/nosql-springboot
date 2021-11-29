package com.zbogdan.app.services

import com.github.javafaker.Faker
import com.zbogdan.app.components.StudentRedisComponent
import com.zbogdan.app.models.redis.Student
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class StudentRedisService {

    @Autowired
    private lateinit var comp: StudentRedisComponent

    fun fetchAll(): Iterable<Student> = comp.findAll()

    fun seedingHash(amount: Int = 5): Unit {
        var i = 0
        repeat(amount) {
            comp.create(
                Student(
                    id = ++i,
                    name = Faker().name().firstName(),
                    email = Faker().name().firstName() + "@" + Faker().company().url(),
                    course = Random.nextInt(1, 5)
                )
            )
            println("Redis data inserted")
        }
    }
}