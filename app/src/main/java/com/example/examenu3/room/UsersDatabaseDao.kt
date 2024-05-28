package com.example.examenu3.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.examenu3.models.Users
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDatabaseDao {
    @Query("SELECT * FROM users")
    fun getUsers(): Flow<List<Users>>

    @Query("SELECT * FROM users WHERE id = :id")
    fun getUser(id: Int): Flow<Users>

    @Insert
    suspend fun addUser(user: Users)

    @Update
    suspend fun updateUser(user: Users)

    @Delete
    suspend fun deleteUser(user: Users)
}