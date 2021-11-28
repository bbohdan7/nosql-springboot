package com.zbogdan.app.components

import com.zbogdan.app.models.redis.Student
import com.zbogdan.app.repos.StudentRedisRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class StudentRedisComponent {

    @Autowired
    private lateinit var repo: StudentRedisRepo

    fun findAll(): Iterable<Student> = repo.findAll()
    fun create(student: Student): Student = repo.save(student)
}