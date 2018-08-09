package com.iolll.nicesome.model.UserInfo

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class HomePageType(@Id @GeneratedValue(strategy = GenerationType.AUTO)
                        var id: Long = 0L,
                        var name: String? = "",
                        var url: String? = "",
                        var homeUrl: String? = "",
                        var icon: String? = ""
)