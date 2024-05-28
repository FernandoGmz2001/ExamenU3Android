package com.example.examenu3.models
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class Users(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("age")
    val age: Int,
)