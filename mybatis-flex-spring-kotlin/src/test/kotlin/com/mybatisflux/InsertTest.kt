package com.mybatisflux

import com.mybatisflex.core.query.QueryChain
import com.mybatisflex.core.query.QueryMethods.column
import com.mybatisflex.core.query.QueryMethods.max
import com.mybatisflex.kotlin.extensions.db.insert
import com.mybatisflex.kotlin.extensions.db.mapper
import com.mybatisflex.kotlin.extensions.db.query
import com.mybatisflex.kotlin.extensions.kproperty.allColumns
import com.mybatisflex.kotlin.extensions.kproperty.column
import com.mybatisflex.kotlin.extensions.kproperty.defaultColumns
import com.mybatisflex.kotlin.extensions.kproperty.eq
import com.mybatisflex.kotlin.extensions.sql.on
import com.mybatisflux.entity.Account
import com.mybatisflux.entity.Book
import com.mybatisflux.mapper.AccountMapper
import com.mybatisflux.vo.AccountVo
import com.mybatisflux.vo.BookVo
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import com.mybatisflux.entity.table.AccountTableDef.ACCOUNT;
import com.mybatisflux.entity.table.BookTableDef.BOOK;


@SpringBootTest
class InsertTest {


    @Autowired
    private lateinit var accountMapper: AccountMapper

    @Test
    fun findAll() {
        val accountMapper: AccountMapper = mapper()


        accountMapper.insert(Account(userName = "test", age = 18))
        accountMapper.selectAll().forEach(::println)
    }

    @Test
    fun findMaxAge() {
        query<Account> {
            select(
                Account::class.allColumns,
                max(Account::age.column).`as`(Account::maxAge.name),
            )
            groupBy(Account::age)
        }.forEach(::println)
    }


    @Test
    fun insertBook() {
        insert(Book(accountId = 1L, title = "title", content = "content"))
    }

    @Test
    fun testManySelect() {
        QueryChain.of(Book::class.java)
            .select(Book::class.allColumns)
            .select(Account::class.allColumns)
            .leftJoin(Account::class.java).on(Account::id eq Book::accountId)
            .listAs(BookVo::class.java)
            .forEach(::println)
    }

    @Test
    fun testSelectAccountVo() {
        QueryChain.of(Account::class.java).apply {
//            select(Account::id.column, Account::class.allColumns)
//            select(Book::id.column, Book::class.allColumns)
            select(ACCOUNT.ID,BOOK.ID, ACCOUNT.ALL_COLUMNS, BOOK.ALL_COLUMNS)
            from(ACCOUNT)
//            select(Account::id.column, *Account::class.defaultColumns)
//            select(Book::id.column, *Book::class.defaultColumns)
            leftJoin(Book::class.java) on (Account::id eq Book::accountId)
            listAs(AccountVo::class.java).forEach(::println)
        }
    }

    @Test
    fun testRe() {
        accountMapper.selectAllWithRelations().forEach(::println)
    }
}
