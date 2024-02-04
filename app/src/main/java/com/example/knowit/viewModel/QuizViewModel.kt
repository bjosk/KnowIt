package com.example.knowit.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import data.Quiz// Import your Quiz data class
import data.ITInfrastructureQuiz
import data.ITServiceManagementQuiz

class QuizViewModel : ViewModel() {
    private val _quizzes = MutableLiveData<List<Quiz>>()
    val quizzes: LiveData<List<Quiz>> = _quizzes

    init {
        loadQuizzes()
    }

    private fun loadQuizzes() {
        // Assuming ITServiceManagementQuiz and ITInfrastructureQuiz are accessible
        _quizzes.value = listOf(ITServiceManagementQuiz, ITInfrastructureQuiz)
    }

    fun getQuizById(id: Int): Quiz? {
        return _quizzes.value?.find { it.Id == id }
    }

    fun updateQuizTimer(quizId: Int, newTimer: Int) {
        val updatedQuizzes = _quizzes.value?.map { quiz ->
            if (quiz.Id == quizId) quiz.apply { timer = newTimer } else quiz
        }
        _quizzes.postValue(updatedQuizzes)
    }

}
