package com.example.knowit.ui

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun QuizConfigScreen(navController: NavController, quizId: Int?) {
    Button(onClick = { /*TODO*/ }) {
        Text(text = quizId.toString())
    }
}