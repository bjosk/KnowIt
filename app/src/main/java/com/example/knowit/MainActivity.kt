package com.example.knowit

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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

import data.Quiz
import data.ITInfrastructureQuiz
import data.ITServiceManagementQuiz

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
                            QuizHolder(
                                quizzes = listOf(
                                    ITInfrastructureQuiz,
                                    ITServiceManagementQuiz
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun QuizHolder(quizzes: List<Quiz>){
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                RoundedCornerShape(16.dp)
            )
            .fillMaxSize()
    ) {
        for (quiz in quizzes){
            QuizCard(quiz)
        }
    }
}

@Composable
fun QuizCard(quiz: Quiz) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(75.dp)
            .border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(8.dp)),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(1.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .clip(CircleShape)
                    .border(1.dp, MaterialTheme.colorScheme.outline, CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                Icon(
                    // Use the appropriate icon from the icons package
                    imageVector = Icons.Default.Star,
                    contentDescription = quiz.name,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.Center)
                        .padding(4.dp)
                )
            }
//            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = quiz.name,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.tertiaryContainer)
                    .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(8.dp))
                    .width(70.dp)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Best:",
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier
                )
                Text(
                    text = "${quiz.highScore}/${quiz.maxScore}",
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
fun Logo(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.know_it),
        modifier = modifier
            .padding(vertical = 50.dp),
        color = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.displayLarge,
        fontWeight = FontWeight.Bold

    )
}

@Preview
@Composable
fun PreviewView(){
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
                    //                        val quizOne = QuizData("IT Service Management", Arrays.asList(Question("Test?", Arrays.asList("wrong", "correct", "wrong", "wrong"), 1)))
                    QuizHolder(quizzes = listOf(ITInfrastructureQuiz, ITServiceManagementQuiz))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewQuizHolder(){
    QuizHolder(quizzes = listOf(ITInfrastructureQuiz, ITServiceManagementQuiz))
}

@Preview(showBackground = true)
@Composable
fun PreviewQuizCard() {
    QuizCard(ITInfrastructureQuiz)
}