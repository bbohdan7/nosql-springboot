package com.zbogdan.app.appchik.components

import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class HomeComponent {

    fun homePage(): String = "Hello World!!!"

    suspend fun suspendingFunction() {
        println("SUSPENDING method is invoked.")
    }

    fun nonSuspend() {
        println("NON-SUSPENDING method is invoked.")
    }

    @PostConstruct
    fun init(): Unit {

    }


}