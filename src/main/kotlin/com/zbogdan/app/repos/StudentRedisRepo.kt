package com.zbogdan.app.repos

import com.zbogdan.app.models.redis.Student
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRedisRepo : CrudRepository<Student, Int>