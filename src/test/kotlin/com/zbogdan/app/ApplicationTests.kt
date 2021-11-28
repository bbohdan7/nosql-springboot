package com.zbogdan.app

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
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

}
