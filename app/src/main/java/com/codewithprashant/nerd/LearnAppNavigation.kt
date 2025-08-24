package com.codewithprashant.nerd

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun LearnAppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("lesson/{title}") { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: "Lesson"
            LessonScreen(title = title, navController = navController)
        }
        composable("explore") {
            ExploreScreen(navController = navController)
        }
        composable("achievements") {
            AchievementsScreen(navController = navController)
        }
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("welcome") {
            WelcomeScreen(navController = navController)
        }
        composable("learn_hub") {
            LearnHubScreen(navController = navController)
        }
        composable("math_topics") {
            MathTopicsScreen(navController = navController)
        }
        composable("subjects") {
            SubjectsScreen(navController = navController)
        }
        composable("courses") {
            CoursesScreen(navController = navController)
        }
        composable("profile") {
            ProfileScreen(navController = navController)
        }
    }
}