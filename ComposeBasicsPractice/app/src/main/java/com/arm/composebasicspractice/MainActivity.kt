package com.arm.composebasicspractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arm.composebasicspractice.ui.theme.ComposeBasicsPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnTogetherImage(
                        stringResource(id = R.string.msn),
                        stringResource(id = R.string.msn2),
                        stringResource(id = R.string.msn3)
                    )
                }
            }
        }
    }
}

@Composable
fun LearnTogether(msn: String, msn2: String, msn3: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = msn,
            fontSize = 24.sp,
            modifier = modifier.padding(16.dp)
        )
        Text(
            text = msn2,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = msn3,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(16.dp)
        )
    }

}

@Composable
fun LearnTogetherImage(msn: String, msn2: String, msn3: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column {
        Image(painter = image, contentDescription = null)
        LearnTogether(msn = msn, msn2 = msn2, msn3 = msn3)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LearnTogetherPreview() {
    ComposeBasicsPracticeTheme {
        LearnTogetherImage(
            msn = stringResource(R.string.msn),
            stringResource(id = R.string.msn2),
            stringResource(id = R.string.msn3)
        )
    }
}