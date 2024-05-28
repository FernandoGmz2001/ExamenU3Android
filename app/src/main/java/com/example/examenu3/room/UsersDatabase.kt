package com.example.examenu3.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.examenu3.models.Users

@Database(
    entities = [Users::class],
    version = 1,
    exportSchema = false
)

abstract class UsersDatabase: RoomDatabase() {
    abstract fun usersDao(): UsersDatabaseDao
}