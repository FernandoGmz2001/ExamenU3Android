package com.example.examenu3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.examenu3.navigation.NavManager
import com.example.examenu3.room.UsersDatabase
import com.example.examenu3.ui.theme.ExamenU3Theme
import com.example.examenu3.viewModels.UsersViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamenU3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val database = Room.databaseBuilder(this,UsersDatabase::class.java, "db_users").build()
                    val dao = database.usersDao()

                    val viewModel = UsersViewModel(dao)

                    NavManager(viewModel = viewModel)
                }
            }
        }
    }
}
