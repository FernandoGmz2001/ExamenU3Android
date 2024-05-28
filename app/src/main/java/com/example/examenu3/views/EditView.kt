package com.example.examenu3.views


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.examenu3.models.Users
import com.example.examenu3.viewModels.UsersViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditView(
    navController: NavController,
    viewModel: UsersViewModel,
    id: Int,
    name: String?,
    age: Int,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Edit View", color = Color.White, fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Go back",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) {
        ContentEditView(it, navController, viewModel, id, name, age)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentEditView(
    it: PaddingValues,
    navController: NavController,
    viewModel: UsersViewModel,
    id: Int,
    name: String?,
    age: Int?,
) {
    var name by remember { mutableStateOf(name ?: "") }
    var age by remember { mutableStateOf(age?.toString() ?: "") }
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(50.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = age ?: "",
            onValueChange = { newAge ->
                if (newAge.toIntOrNull() != null) {
                    age = newAge
                }
            },
            label = { Text(text = "Age") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)
        )

        Button(
            onClick = {
                val user = Users(id = id, name = name, age = age.toInt())

                viewModel.updateUser(user)
                showDialog = true
            }
        ) {
            Text(text = "Edit")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Operation Result") },
                text = { Text("User updated successfully!") },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog = false
                            navController.popBackStack()
                        }
                    ) {
                        Text("OK")
                    }
                }
            )
        }
    }
}
