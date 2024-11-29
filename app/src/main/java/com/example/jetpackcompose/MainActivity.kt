package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedTextScreen()
        }
    }
}

@Composable
fun AnimatedTextScreen() {
    var isVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { isVisible = !isVisible }
            ) {
                Text(if (isVisible) "Отказ не принимается" else "Поставите нам 80?")
            }

            Spacer(modifier = Modifier.height(20.dp))


            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn() + scaleIn(initialScale = 0.8f),
                exit = fadeOut() + scaleOut(targetScale = 0.8f)
            ) {
                Text(
                    text = "Дааа!",
                    fontSize = 24.sp,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAnimatedTextScreen() {
    AnimatedTextScreen()
}
