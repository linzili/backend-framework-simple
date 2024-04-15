package com.mybatisflux.entity

import com.mybatisflex.annotation.Table


@Table("tb_idcard")
data class IDCard(

    var accountId: Long? = null,
    var cardNo: String? = null,
    var content: String? = null,
)
