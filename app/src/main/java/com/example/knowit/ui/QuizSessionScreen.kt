package com.example.knowit.ui

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.knowit.viewModel.QuizViewModel

@Composable
fun QuizSessionScreen(navController: NavController, quizId: Int?) {

    val viewModel : QuizViewModel = viewModel()
    val quiz = quizId?.let { viewModel.getQuizById(it) }

    Button(onClick = { /*TODO*/ }) {
        Text(text = quiz!!.timer.toString())
    }
}