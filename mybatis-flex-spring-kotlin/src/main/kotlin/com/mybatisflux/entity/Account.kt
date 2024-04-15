package com.mybatisflux.entity

import com.mybatisflex.annotation.*
import com.mybatisflex.core.activerecord.MapperModel
import com.mybatisflex.core.keygen.KeyGenerators
import java.util.*

@Table("tb_account")
data class Account(
    @Id(keyType = KeyType.Generator, value = KeyGenerators.snowFlakeId)
    var id: Long? = null,
    var userName: String? = null,
    var age: Int? = null,
    var birthday: Date? = null,
    @Column(ignore = true)
    var maxAge: Int? = null,

    @RelationOneToOne(selfField = "id", targetField = "accountId")
    var idCard: IDCard? = null,
) : MapperModel<Account>
