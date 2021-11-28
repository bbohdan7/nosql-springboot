package com.zbogdan.app.services

import com.zbogdan.app.components.ProductMongoComponent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class ProductMongoService {

    @Autowired
    private lateinit var comp: ProductMongoComponent

    @PostConstruct
    fun init(): Unit {
        val result = comp.findById("61a21d18cdec5672757480f1")
        println("Product to be found: $result")
    }
}