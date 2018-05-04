package com.iolll.nicesome.model.base

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class UrlRecord(@Id @GeneratedValue(strategy = GenerationType.AUTO)
                     var id: Long = 0L,
                     var userid: Int = 0,
                     var name: String = "",
                     var icon: String? = "img/icon_record.png",
                     var type: String? = "",
                     var url: String = "#",
                     var useNum: Int = 0,
                     var forkNum: Int = 0,
                     var starNum: Int = 0
                 )