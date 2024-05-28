package com.example.examenu3.states

import com.example.examenu3.models.Users

data class UsersState(
    val usersList: List<Users> = emptyList()
)
