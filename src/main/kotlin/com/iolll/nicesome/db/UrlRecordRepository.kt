package com.iolll.nicesome.db

import com.iolll.nicesome.model.base.UrlRecord
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface UrlRecordRepository : CrudRepository<UrlRecord, Long> {

    fun findByUserid(userid: String): List<UrlRecord>

    @Query("from UrlRecord u where u.type=:type")
    fun findUrlRecord(@Param("type") type: String): List<UrlRecord>


}
