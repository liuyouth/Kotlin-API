package com.iolll.nicesome.db

import com.iolll.nicesome.model.base.UrlRecord
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface UrlRecordRepository : CrudRepository<UrlRecord, Long> {

    fun findByLastName(lastName: String): List<UrlRecord>

    @Query("from urlrecord c where c.type=:type")
    fun findByType(@Param("type") type: String): List<UrlRecord>

}
