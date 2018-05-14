package com.iolll.nicesome.model.base

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class User(@Id @GeneratedValue(strategy = GenerationType.AUTO)
                var id: Long = 0L,
                var name: String ?= "",
                var phone: String ?= "",
                var email: String ?= "",
                var address: String ?= "",
                @JsonIgnore
                var pwd: String = "",
                @JsonIgnore
                var salt: String = "",
                @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
                var List :List<UrlRecord> ?= ArrayList()
                )