package com.example.taskmanager


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                Surface {
                    TaskCompletedImage(
                        message = stringResource(R.string.all_tasks_completed),
                        description = stringResource(R.string.nice_work)
                    )
                }
            }
        }
    }
}

@Composable
fun TaskCompletedText(
    message: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = message,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .padding(
                top = 24.dp,
                bottom = 8.dp
            )
    )
    Text(
        text = description,
        fontSize = 16.sp
    )
}


@Composable
fun TaskCompletedImage(
    message: String,
    description: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.ic_task_completed)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()                         //ocupa toda a tela
            .background(Color.LightGray)
    ) {
        Image(
            painter = image,
            contentDescription = null
        )
        TaskCompletedText(
            message = message,
            description = description
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TaskManagerPreview() {
    TaskManagerTheme {
        TaskCompletedImage(
            message = stringResource(R.string.all_tasks_completed),
            description = stringResource(R.string.nice_work),
            modifier = Modifier
        )
    }
}