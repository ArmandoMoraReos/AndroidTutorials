package com.arm.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arm.artspaceapp.ui.theme.ArtSpaceAppTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}


@Composable
fun ArtImage(@DrawableRes picture: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = picture),
        null,
        modifier = modifier
    )
}

@Composable
fun TextImageDescription(
    pictureTitle: String,
    pictureAuthor: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)
            .fillMaxSize(),
    ) {
        Text(
            text = pictureTitle,
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = modifier
        )
        Text(
            text = pictureAuthor,
            textAlign = TextAlign.Start,
            modifier = modifier
        )
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
fun ArtButtons(
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = onPrevious) {
            Text(text = stringResource(R.string.previous_button))
        }

        Button(onClick = onNext) {
            Text(text = stringResource(R.string.next_button))
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var picture by remember { mutableStateOf(R.drawable.img1) }
    val title: String
    val author: String
    var step by remember { mutableStateOf(1) }
     when (step) {
        1 -> {
            picture = R.drawable.img1
            title = stringResource(R.string.title_img1)
            author = stringResource(R.string.author_img1)
        }
        2 -> {
            picture = R.drawable.img2
            title = stringResource(R.string.title_img2)
            author = stringResource(R.string.authot_img2)
            R.drawable.img2
        }
        else ->{
            picture = R.drawable.img3
            title = stringResource(R.string.title_img3)
            author = stringResource(R.string.authot_img3)
        }
    }
    Column(
        Modifier.fillMaxSize()
    ) {
        Row(Modifier.weight(4f)) {
            ArtImage(
                picture,
                Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            )
        }
        Row(
            Modifier
                .weight(1f)
                .wrapContentSize(Alignment.BottomCenter)
        ) {
            TextImageDescription(
                pictureTitle = title,
                pictureAuthor = author,
                modifier = Modifier.fillMaxWidth()
                .background(Color(0x44aaaaff))
                .padding(start = 20.dp, bottom = 20.dp)
            )
        }
        Row(Modifier.wrapContentSize(Alignment.BottomCenter)) {
            ArtButtons(
                onPrevious = {
                    if (step > 1) {
                        step--
                    }
                },
                onNext = {
                    if (step < 3) {
                        step++
                    }
                },
                Modifier
                    .wrapContentSize(Alignment.BottomCenter)
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}