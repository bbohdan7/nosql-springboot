package com.zbogdan.app.services

import com.zbogdan.app.components.HomeComponent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class HomeService {

    @Autowired
    private lateinit var homeComponent: HomeComponent

    @PostConstruct
    fun init(): Unit = println("Home Service invoked")

    fun home(): String = homeComponent.homePage()
}