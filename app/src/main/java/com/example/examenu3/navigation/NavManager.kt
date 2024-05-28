package com.example.examenu3.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.examenu3.viewModels.UsersViewModel
import com.example.examenu3.views.StartView
import com.example.examenu3.views.AddView
import com.example.examenu3.views.EditView

@Composable
fun NavManager(viewModel: UsersViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "start") {
        composable("start") {
            StartView(navController, viewModel)
        }
        composable("add") {
            AddView(navController, viewModel)
        }
        composable(
            "edit/{id}/{name}", arguments = listOf(
                navArgument("id") { type = NavType.IntType },
                navArgument("name") { type = NavType.StringType },
            )
        ) {
            EditView(
                navController,
                viewModel,
                it.arguments!!.getInt("id"),
                it.arguments?.getString("name"),
                it.arguments!!.getInt("age")
            )
        }
    }
}