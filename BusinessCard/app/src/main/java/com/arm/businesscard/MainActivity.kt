package com.arm.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arm.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0x4800aa00)),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageCard()
        ContactInfo()
    }
}

@Composable
fun ImageCard(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = modifier.background(Color.Black)) {
            Image(painter = image, contentDescription = null, Modifier.width(150.dp))
        }
        Text(
            text = stringResource(R.string.name_str),
            fontSize = 40.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(10.dp)
        )
        Text(
            text = stringResource(R.string.text_msg),
            fontSize = 18.sp
        )
    }
}

@Composable
fun ContactImage(image: Painter, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(painter = image, contentDescription = null, Modifier.width(40.dp))
    }
}

@Composable
fun ContactInfo(modifier: Modifier = Modifier) {
    Column(Modifier.width(300.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Row(horizontalArrangement = Arrangement.Center){
            ContactImage(
                painterResource(id = R.drawable.baseline_local_phone_24),
                Modifier.weight(1f)
            )
            Text(text = "+3310701900", Modifier.weight(4f))
        }
        Row {
            ContactImage(
                painterResource(id = R.drawable.baseline_share_24),
                modifier = Modifier.weight(1f)
            )
            Text(text = "+@ArmandoMr", modifier = Modifier.weight(4f))
        }
        Row {
            ContactImage(
                painterResource(id = R.drawable.baseline_email_24),
                modifier = Modifier.weight(1f)
            )
            Text(text = "arm.antonio.mr@gmail.com", modifier = Modifier.weight(4f))
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}