package com.arm.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arm.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}


@Composable
fun ButtonAndText(modifier: Modifier = Modifier) {
    var step by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }
    var message: String
    var painter: Painter

    fun onClick() {
        step = when (step) {
            1 -> {
                squeezeCount = (2..4).random()
                2
            }
            2 -> {
                squeezeCount--
                if (squeezeCount == 0) {
                    3
                } else {
                    2
                }
            }
            3 -> 4
            else -> 1
        }
    }

    when (step) {
        1 -> {
            message = stringResource(id = R.string.lemon_tree)
            painter = painterResource(id = R.drawable.lemon_tree)
        }

        2 -> {
            message = stringResource(id = R.string.lemon)
            painter = painterResource(id = R.drawable.lemon_squeeze)
        }

        3 -> {
            message = stringResource(id = R.string.glass_lemonade)
            painter = painterResource(id = R.drawable.lemon_drink)
        }

        else -> {
            message = stringResource(id = R.string.empty_glass)
            painter = painterResource(id = R.drawable.lemon_restart)
        }
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = ::onClick,
            shape = RoundedCornerShape(35.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0x7788ff33)
            )
            /*modifier = Modifier
                .background(Color(0x1133aa00), shape = RoundedCornerShape(35.dp))*/
        ) {
            Image(
                painter = painter,
                contentDescription = message
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = message, fontSize = 18.sp)
    }
}

@Composable
fun LemonadeApp() {
    ButtonAndText(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    LemonadeAppTheme {
        LemonadeApp()
    }
}