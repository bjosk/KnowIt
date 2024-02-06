package com.example.knowit.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import data.ITServiceManagementQuiz
import data.Quiz
import com.example.knowit.viewModel.QuizzesViewModel
import data.ITInfrastructureQuiz

class QuizViewModel : ViewModel() {
    private val _currentQuiz = mutableStateOf<Quiz?>(null)
    val currentQuiz: State<Quiz?> = _currentQuiz

    fun loadQuizById(quizId: Int) {
        // Assuming you have a way to find a quiz by ID
        _currentQuiz.value = findQuizById(quizId)
    }

    private fun findQuizById(quizId: Int): Quiz? {
        // Fetch the quiz by ID from your quizzes list or repository
        // This is a placeholder for actual implementation
        val quizzes = listOf(ITInfrastructureQuiz, ITServiceManagementQuiz)

        return quizzes.find { it.Id == quizId }
    }

    fun increaseTimer(amount: Int) {
        val currentQuiz = _currentQuiz.value
        if (currentQuiz != null) {
            // Assuming _currentQuiz is a MutableState<Quiz?> or similar
            // Update the timer within the existing quiz object
            currentQuiz.timer += 10
        }
    }
}
