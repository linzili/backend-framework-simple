package com.mybatisflux.vo

import com.mybatisflux.entity.Account

data class BookVo(
    var id: Long? = null,
    var accountId: Long? = null,
    var title: String? = null,
    var content: String? = null,
    var account: Account? = null,
//    var userName: String? = null,
//    var userAge: Int? = null,
)
