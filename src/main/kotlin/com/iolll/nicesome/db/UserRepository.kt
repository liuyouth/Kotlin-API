package com.iolll.nicesome.db

import com.iolll.nicesome.model.UserInfo.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    fun findByName(name: String): List<User>
    fun findByEmail(email: String): List<User>
    fun findByNikeName(nikeName: String): List<User>

//
//    @Query("from User u where u.firstName=:name")
//    fun findUser(@Param("name") name: String): List<User>
}