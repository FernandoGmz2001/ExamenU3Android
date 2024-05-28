package com.example.examenu3.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examenu3.models.Users
import com.example.examenu3.room.UsersDatabaseDao
import com.example.examenu3.states.UsersState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class UsersViewModel(
    private val dao: UsersDatabaseDao
): ViewModel() {
    var state by mutableStateOf(UsersState())
        private set

    init {
       viewModelScope.launch {
           dao.getUsers().collectLatest {
               state = state.copy(
                   usersList = it
               )
           }
       }
    }

    fun addUser(user: Users) = viewModelScope.launch {
        dao.addUser(user = user)
    }

    fun updateUser(user: Users) = viewModelScope.launch {
        dao.updateUser(user = user)
    }

    fun deleteUser(user: Users) = viewModelScope.launch {
        dao.deleteUser(user = user)
    }
}