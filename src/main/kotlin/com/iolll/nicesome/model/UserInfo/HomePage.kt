package com.iolll.nicesome.model.UserInfo

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class HomePage(@Id @GeneratedValue(strategy = GenerationType.AUTO)
                    var id: Long = 0L,
                    var url: String? = "",
                    var type: HomePageType
)