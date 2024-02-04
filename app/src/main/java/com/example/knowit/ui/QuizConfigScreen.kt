package com.example.knowit.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.knowit.viewModel.QuizViewModel
import kotlin.math.roundToInt

@Composable
fun QuizConfigScreen(navController: NavController, quizId: Int?) {

    val viewModel : QuizViewModel = viewModel()
    val quiz = quizId?.let { viewModel.getQuizById(it) }

    val sliderPosition = remember { mutableStateOf(quiz?.timer?.toFloat() ?: 30f) }

    Column {
        //updates only after next screen
        Button(onClick = {
            if (quizId != null && quiz != null) {
//                viewModel.updateQuizTimer(quizId, quiz.timer + 10)
                quiz.timer += 10
            }
        }) {

        }
        Text(text = "${quiz!!.timer}")

        //Look into this slider
        Slider(
            value = sliderPosition.value,
            onValueChange = { newValue ->
                val adjustedValue = 5 * (newValue / 5).roundToInt()
                sliderPosition.value = adjustedValue.toFloat()
                viewModel.updateQuizTimer(quizId, sliderPosition.value.toInt())
            },
            steps = 6,
            valueRange = 5f..60f,
        )

        Button(onClick = { navController.navigate("quizSession/${quiz!!.Id}") }) {
            Text(text = quiz!!.name)
        }
    }
}