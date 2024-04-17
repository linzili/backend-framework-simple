package com.mybatisflux

import com.mybatisflex.core.query.QueryChain
import com.mybatisflex.core.query.QueryMethods.*
import com.mybatisflex.kotlin.extensions.db.insert
import com.mybatisflex.kotlin.extensions.db.mapper
import com.mybatisflex.kotlin.extensions.db.query
import com.mybatisflex.kotlin.extensions.kproperty.allColumns
import com.mybatisflex.kotlin.extensions.kproperty.column
import com.mybatisflex.kotlin.extensions.kproperty.eq
import com.mybatisflux.entity.Account
import com.mybatisflux.entity.Book
import com.mybatisflux.mapper.AccountMapper
import com.mybatisflux.vo.AccountVo
import com.mybatisflux.vo.BookVo
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


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
//        QueryChain.of(Account::class.java).apply {
////            select(Account::id.column, Account::class.allColumns)
////            select(Account::id)
////            select(Book::id.column, Book::class.allColumns)
//            select(ACCOUNT.ID, BOOK.ID, ACCOUNT.ALL_COLUMNS, BOOK.ALL_COLUMNS)
////            select(ACCOUNT.ALL_COLUMNS, BOOK.ALL_COLUMNS)
//            from(ACCOUNT)
////            select(Account::id.column, *Account::class.defaultColumns)
////            select(Book::id.column, *Book::class.defaultColumns)
//            leftJoin(Book::class.java) on (Account::id eq Book::accountId)
//            listAs(AccountVo::class.java).forEach(::println)
//        }
        QueryChain.of(Account::class.java)
//            select(Account::id.column, Account::class.allColumns)
//            select(Account::id)
//            select(Book::id.column, Book::class.allColumns)
//            .select(ACCOUNT.ALL_COLUMNS, BOOK.ALL_COLUMNS)
//            .select(ACCOUNT.DEFAULT_COLUMNS, BOOK.DEFAULT_COLUMNS)
//            .select()
            .select(Account::class.allColumns, Book::class.allColumns, Account::id.column, Book::id.column)
//            select(Account::id.column, *Account::class.defaultColumns)
//            select(Book::id.column, *Book::class.defaultColumns)
            .leftJoin(Book::class.java).on(Account::id eq Book::accountId)
            .listAs(AccountVo::class.java)
            .forEach(::println)

    }

    @Test
    fun testRe() {
        accountMapper.selectAllWithRelations().forEach(::println)
    }


    @Test
    fun test1() {
        var obj = QueryChain.of(Account::class.java)
            .select(if_(Account::age eq 19, true_(), false_()))
            .where(Account::age eq 19)
            .objAs(Boolean::class.java)
        println(obj)
    }
}
