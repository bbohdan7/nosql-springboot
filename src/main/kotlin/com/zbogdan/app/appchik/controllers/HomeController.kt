package com.zbogdan.app.appchik.controllers

import com.zbogdan.app.appchik.services.HomeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    @Autowired
    private lateinit var service: HomeService

    @GetMapping("/home")
    fun homePage(model: Model): String {
        model.addAttribute("content", service.home())
        return "home"
    }
}