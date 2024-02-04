package com.example.knowit

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.knowit.ui.theme.KnowItTheme
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import data.Quiz
import data.ITInfrastructureQuiz
import data.ITServiceManagementQuiz

import com.example.knowit.ui.QuizzesListScreen
import com.example.knowit.ui.QuizConfigScreen
import com.example.knowit.ui.QuizSessionScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizApp()
        }
    }
}

@Preview
@Composable
fun QuizApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "quizzesList") {
        composable("quizzesList") { QuizzesListScreen(navController) }
        composable("quizConfig/{quizId}") { backStackEntry ->
            // Retrieve the quiz ID from the back stack entry
            val quizId = backStackEntry.arguments?.getString("quizId")?.toIntOrNull()
            QuizConfigScreen(navController, quizId)
        }
        composable("quizSession/{quizId}") { backStackEntry ->
            // Retrieve the quiz ID from the back stack entry
            val quizId = backStackEntry.arguments?.getString("quizId")?.toIntOrNull()
            QuizSessionScreen(navController, quizId)
        }
    }
}

//@Preview
//@Composable
//fun PreviewView(){
//    KnowItTheme {
//        // A surface container using the 'background' color from the theme
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            Box(
//                modifier = Modifier
//                    .padding(8.dp)
//            ) {
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Logo()
//                    //                        val quizOne = QuizData("IT Service Management", Arrays.asList(Question("Test?", Arrays.asList("wrong", "correct", "wrong", "wrong"), 1)))
//                    QuizHolder(quizzes = listOf(ITInfrastructureQuiz, ITServiceManagementQuiz), null)
//                }
//            }
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewQuizHolder(){
//    QuizHolder(quizzes = listOf(ITInfrastructureQuiz, ITServiceManagementQuiz), null)
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewQuizCard() {
//    QuizCard(ITInfrastructureQuiz, null)
//}