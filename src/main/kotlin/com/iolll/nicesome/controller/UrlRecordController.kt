package com.iolll.nicesome.controller

import com.iolll.nicesome.db.UrlRecordRepository
import com.iolll.nicesome.model.base.PageResult
import com.iolll.nicesome.model.base.RBuilder
import com.iolll.nicesome.model.base.RBuilder.Seccess
import com.iolll.nicesome.model.base.Result
import com.iolll.nicesome.model.base.UrlRecord
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.util.StringUtils.isEmpty
import java.util.ArrayList


@RestController
@RequestMapping("/urlrecord/")
class UrlRecordController {
    @Autowired
    lateinit var repository: UrlRecordRepository

    @GetMapping("/")
    fun list(@RequestParam(value = "name", defaultValue = "") name: String,
             @RequestParam(value = "type", defaultValue = "") type: String,
             @RequestParam(value = "page", defaultValue = "0") page: Int,
             @RequestParam(value = "size", defaultValue = "15") size: Int): PageResult<UrlRecord> {
        val pageNum = if (page == 0) {
            0
        } else {
            page - 1
        }
        val sort = Sort(Sort.Direction.ASC, "id")
        val pageable = PageRequest(pageNum, size, sort)

        val data = if (isEmpty(name) && isEmpty(type)) {
            repository.findAll(pageable)
        } else if (isEmpty(type)) {
            repository.findByNameLike(name, pageable)
        } else {
            repository.findByTypeLike(type, pageable)
        }

        return RBuilder.Seccess(data.toList(), data.totalElements, data.totalPages)

    }

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long): UrlRecord {
        return repository.findOne(id)
    }

    @PostMapping("/")
    fun add(@RequestBody body: UrlRecord): UrlRecord {
        body.id = 0L
        return repository.save(body)
    }

    @PutMapping("/")
    fun update(@RequestBody body: UrlRecord): UrlRecord {
        return repository.save(body)
    }

    @DeleteMapping("/{id}")
    fun del(@PathVariable("id") id: Long) {
        return repository.delete(id)
    }


}