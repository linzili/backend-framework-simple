package com.mybatisflux.entity

import com.mybatisflex.annotation.Id
import com.mybatisflex.annotation.KeyType
import com.mybatisflex.annotation.Table
import com.mybatisflex.core.keygen.KeyGenerators
import java.util.*

@Table("tb_account")
data class Account(
    @Id(keyType = KeyType.Generator, value = KeyGenerators.snowFlakeId)
    var id: Int = -1,
    var userName: String? = null,
    var age: Int? = null,
    var birthday: Date? = null,
)
