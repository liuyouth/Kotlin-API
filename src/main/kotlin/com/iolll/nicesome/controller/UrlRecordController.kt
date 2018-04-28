package com.iolll.nicesome.controller

import com.iolll.nicesome.db.UrlRecordRepository
import com.iolll.nicesome.model.base.UrlRecord
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/urlrecord/")
class UrlRecordController {
    @Autowired
    lateinit var repository: UrlRecordRepository

    @RequestMapping("/allList")
    fun index(model: Model): List<UrlRecord> {
        return repository.findAll().toList()
    }

}