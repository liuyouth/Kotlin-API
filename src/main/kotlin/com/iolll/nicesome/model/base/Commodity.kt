package com.iolll.nicesome.model.base

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Commodity(@Id @GeneratedValue(strategy = GenerationType.AUTO)
                     val id: Long = 0L,
                     val name: String = "",
                     val price: Double = 0.0,
                     val saleNum: Int = 0,
                     val type: String = "",
                     val pics: ArrayList<String> = ArrayList(),
                     val urls: ArrayList<String> = ArrayList())