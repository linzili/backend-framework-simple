package com.mybatisflux.vo

import com.mybatisflux.entity.Book
import java.util.*


data class AccountVo(
    var id: Long? = null,
    var userName: String? = null,
    var age: Int? = null,
    var birthday: Date? = null,
    var book: List<Book>?=null
)
