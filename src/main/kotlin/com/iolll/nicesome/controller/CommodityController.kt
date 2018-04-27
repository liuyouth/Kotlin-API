package com.iolll.nicesome.controller

import com.iolll.nicesome.db.CommodityRepository
import com.iolll.nicesome.model.base.User
import com.iolll.nicesome.db.UserRepository
import com.iolll.nicesome.model.base.Commodity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/commodity/")
class CommodityController {
    @Autowired
    lateinit var repository: CommodityRepository

    @RequestMapping("/allList")
    fun index(model: Model): List<Commodity> {
        return repository.findAll().toList()
    }

}