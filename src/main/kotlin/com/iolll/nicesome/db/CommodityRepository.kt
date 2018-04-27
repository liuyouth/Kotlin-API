package com.iolll.nicesome.db

import com.iolll.nicesome.model.base.Commodity
import com.iolll.nicesome.model.base.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface CommodityRepository : CrudRepository<Commodity, Long> {

    fun findByLastName(lastName: String): List<Commodity>

    @Query("from commodity c where c.type=:type")
    fun findByType(@Param("type") type: String): List<Commodity>

}
