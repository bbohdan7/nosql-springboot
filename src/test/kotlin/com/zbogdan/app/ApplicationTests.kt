package com.zbogdan.app

import com.zbogdan.app.services.ProductCassandraService
import com.zbogdan.app.services.ProductCouchbaseService
import com.zbogdan.app.services.ProductMongoService
import com.zbogdan.app.services.StudentRedisService
import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ApplicationTests {

    suspend fun printMessage(): Unit = coroutineScope {
        launch {
            println("Hello, World! Thread: ${Thread.currentThread().name}")
            delay(1000L)
        }
    }

    suspend fun printAnotherMessage(): Unit = coroutineScope {
        launch {
            println("Hello, another time! Thread: ${Thread.currentThread().name}")
            delay(2000L)
        }
    }

    @Test
    fun testCoroutine(): Unit {
        runBlocking {
            var i: Int = 0
            while (++i < 20) {
                printMessage()
                printAnotherMessage()
            }
        }
        GlobalScope.launch {
            printMessage()
            printAnotherMessage()
        }
    }

    @Autowired
    private lateinit var redisService: StudentRedisService

    @Autowired
    private lateinit var couchbaseService: ProductCouchbaseService

    @Autowired
    private lateinit var cassandraService: ProductCassandraService

    @Autowired
    private lateinit var mongoService: ProductMongoService

    @Test
    fun testRedis(): Unit {
//        redisService.fetchAll().forEach(System.out::println)
//        couchbaseService.fetchAll().forEach(System.out::println)
        cassandraService.fetchAll().forEach(System.out::println)
//        mongoService.fetchByLike("^Sm", 0.03f, false).forEach(System.out::println)
    }

}
