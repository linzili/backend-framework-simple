package com.mybatisflux.entity

import com.mybatisflex.annotation.ColumnAlias
import com.mybatisflex.annotation.Id
import com.mybatisflex.annotation.KeyType
import com.mybatisflex.annotation.Table
import com.mybatisflex.core.keygen.KeyGenerators

@Table("tb_book")
data class Book(
    @Id(keyType = KeyType.Generator, value = KeyGenerators.snowFlakeId)
    @ColumnAlias("bookId")
    var id: Long? = null,
    var accountId: Long? = null,
    var title: String? = null,
    var content: String? = null,

    )
