package com.example.knowit.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import data.Quiz// Import your Quiz data class
import data.ITInfrastructureQuiz
import data.ITServiceManagementQuiz

class QuizzesViewModel : ViewModel() {
    private var _quizzes = mutableStateOf(listOf<Quiz>())
    val quizzes: State<List<Quiz>> = _quizzes

    init {
        loadQuizzes()
    }

    private fun loadQuizzes() {
        // Load quizzes from a static source or repository
        _quizzes.value = listOf(ITInfrastructureQuiz, ITServiceManagementQuiz)
    }

}
