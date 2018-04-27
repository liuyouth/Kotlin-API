package com.iolll.nicesome.controller

import com.sun.org.apache.xpath.internal.operations.Mod
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class PageController {
    /**
     * 前台首页
     */
    @RequestMapping("/")
    fun index(model: Model): String {
        println("reception/index")
        return "reception/index"
    }

    /**
     * 前台首页
     */
    @RequestMapping("/admin")
    fun adminIndex(model: Model): String {
        println("back/index")
        return "back/index"
    }


}