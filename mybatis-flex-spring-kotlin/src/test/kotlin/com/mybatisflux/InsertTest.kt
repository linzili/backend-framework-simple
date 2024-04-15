package com.mybatisflux

import com.mybatisflex.kotlin.extensions.db.baseMapper
import com.mybatisflex.kotlin.extensions.db.mapper
import com.mybatisflux.entity.Account
import com.mybatisflux.mapper.AccountMapper
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class InsertTest {


    @Test
    fun findAll() {
        val accountMapper: AccountMapper = mapper()
        accountMapper.insert(Account(userName = "test", age = 18))
        accountMapper.selectAll().forEach(::println)
    }
}
