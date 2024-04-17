package com.satoken.model

import com.mybatisflex.annotation.Table
import com.satoken.NoArg


@Table("tb_account")
data class Account(
    var name: String,
    var age: Int
)
