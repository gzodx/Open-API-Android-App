package com.codingwithmitch.openapi.persistence

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codingwithmitch.openapi.models.AccountProperties
import com.codingwithmitch.openapi.models.AuthToken

@Dao
interface AccountPropertiesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAndReplace(accountProperties: AccountProperties): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertOrIgnore(accountProperties: AccountProperties): Long

    @Query("UPDATE account_properties SET email = :email, username = :username WHERE pk = :pk")
    fun updateAccountProperties(pk: Int, email: String, username: String)

    @Query("DELETE FROM account_properties")
    suspend fun deleteAll(): Int

    @Query("SELECT * FROM account_properties WHERE email = :email")
    suspend fun searchByEmail(email: String): AccountProperties?

    @Query("SELECT * FROM account_properties WHERE pk = :pk")
    fun searchByPk(pk: Int): LiveData<AccountProperties>

    @Query("SELECT * FROM account_properties")
    suspend fun selectAll(): List<AccountProperties>
}
















