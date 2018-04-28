package com.iolll.nicesome.model.base

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class UrlRecord(@Id @GeneratedValue(strategy = GenerationType.AUTO)
                     val id: Long = 0L,
                     val name: String = "",
                     val icon: String = "img/icon_record.png",
                     val type: String = "",
                     val url: String = "#",
                     val useNum: Int = 0,
                     val forkNum: Int = 0,
                     val starNum: Int = 0
                 )