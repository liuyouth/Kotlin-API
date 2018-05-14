package com.iolll.nicesome.model.base

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class UrlRecord(
        /**
         * 自增主键ID
         */
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0L,
        /**
         * 归属用户
         */
        var userid: Int = 0,
        /**
         * 姓名
         */
        var name: String = "",
        /**
         * 默认icon
         */
        var icon: String? = "img/icon_record.png",
        /**
         * 类型
         */
        var type: String? = "",
        /**
         * 空间
         */
        var space: String? = "",
        /**
         * URL地址
         */
        var url: String = "#",
        /**
         * 是否对所有人可以见
         */
        var isOpenAll: Boolean? = false,
        /**
         * 使用次数
         */
        var useNum: Int = 0,
        /**
         * 从这里添加到自己的库的数量
         */
        var forkNum: Int = 0,
        /**
         * 点赞数量
         */
        var starNum: Int = 0
)