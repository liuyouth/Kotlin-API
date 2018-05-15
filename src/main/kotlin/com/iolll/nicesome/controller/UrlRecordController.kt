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
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@RestController
@RequestMapping("/urlrecord/")
class UrlRecordController {
    @Autowired
    lateinit var repository: UrlRecordRepository
    @Autowired
    @PersistenceContext
    lateinit var entityManager: EntityManager

    @GetMapping("/")
    fun list(@RequestParam(value = "name", defaultValue = "") name: String,
             @RequestParam(value = "type", defaultValue = "") type: String,
             @RequestParam(value = "page", defaultValue = "0") page: Int,
             @RequestParam(value = "size", defaultValue = "15") size: Int,
             @RequestParam(value = "userid", defaultValue = "15") userId: Long,
             @RequestParam(value = "sortField", defaultValue = "") filedName: String,
             @RequestParam(value = "sortOrder", defaultValue = "") sortOrder: String): PageResult<UrlRecord> {
        val pageNum = if (page == 0) {
            0
        } else {
            page - 1
        }
        var sd: Sort.Direction
        var filedNames: String = filedName
        when (sortOrder) {
            "descend" -> sd = Sort.Direction.DESC
            else -> sd = Sort.Direction.ASC
        }
        println(sortOrder + "\n")
        println(filedName)
        if (isEmpty(filedName))
            filedNames = "id"
        val sort = Sort(sd, filedNames)
        val pageable = PageRequest(pageNum, size, sort)
        val data = if (userId==0L) {

            if (isEmpty(name) && isEmpty(type)) {
                repository.findAll(pageable)
            } else if (isEmpty(type)) {
                repository.findByNameLike(name, pageable)
            } else {
                repository.findByTypeLike(type, pageable)
            }
        }else{
             if (isEmpty(name) && isEmpty(type)) {
                repository.findByUser_id(userId,pageable)
            } else if (isEmpty(type)) {
                repository.findByNameLike(name, pageable)
            } else {
                repository.findByTypeLike(type, pageable)
            }
        }
        var q = entityManager?.createNativeQuery("select * from url_record", UrlRecord::class.java)
        var list :List<UrlRecord> = q.resultList.toList() as List<UrlRecord>
        return RBuilder.Seccess(list, data.totalElements, data.totalPages)

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