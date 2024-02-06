package com.example.knowit.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.knowit.ui.theme.KnowItTheme
import com.example.knowit.viewModel.QuizViewModel
import com.example.knowit.viewModel.QuizzesViewModel
import data.Quiz

@Composable
fun QuizConfigScreen(navController: NavController, quizId: Int, quizViewModel: QuizViewModel = viewModel()) {
    quizViewModel.loadQuizById(quizId)
    KnowItTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Logo()
                    Text(text = quizViewModel.currentQuiz.value?.name ?: "unknown")
                    Button(onClick = { quizViewModel.increaseTimer(10) }) {
                        
                    }
                    Text(text = quizViewModel.currentQuiz.value?.timer.toString() ?: "NaN")

                }
            }
        }
    }
}