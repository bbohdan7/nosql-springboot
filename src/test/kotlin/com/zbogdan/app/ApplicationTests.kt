package com.zbogdan.app

import com.zbogdan.app.services.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ApplicationTests {
    @Autowired
    private lateinit var redisService: StudentRedisService

    @Autowired
    private lateinit var mongoService: ProductMongoService

    @Autowired
    private lateinit var mysqlService: ProductMysqlService

    @Test
    fun testRedis(): Unit {
//        redisService.fetchAll().forEach(System.out::println)
//        couchbaseService.fetchAll().forEach(System.out::println)
//        cassandraService.fetchAll().forEach(System.out::println)
//        mongoService.fetchByLike("^Sm", 0.03f, false).forEach(System.out::println)
//        mysqlService.seedingMysql(5000)
        //mysqlService.fetchAll().forEach(System.out::println)

    }

}
