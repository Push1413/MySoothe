package com.example.androiddevchallenge.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.utils.MySootheButton

@Composable
fun WelcomeScreen() {
    val isLight = MaterialTheme.colors.isLight
    // by default setting resources value as per dark theme.
    var backgroundResource = R.drawable.ic_dark_welcome
    var backgroundLogo = R.drawable.ic_dark_logo
    if (isLight) {
        backgroundResource = R.drawable.ic_light_welcome
        backgroundLogo = R.drawable.ic_light_logo
    }

    WelcomeBackground(backgroundResource)

    ScreenContent(backgroundLogo)
}

@Composable
private fun ScreenContent(backgroundLogo: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painterResource(id = backgroundLogo),
            contentDescription = "Logo"
        )

        Spacer(modifier = Modifier.height(32.dp))

        MySootheButton(
            onClick = {},
            buttonText = "SIGN UP"
        )

        Spacer(modifier = Modifier.height(8.dp))

        MySootheButton(
            onClick = {},
            buttonText = "LOG IN",
            backgroundColor = MaterialTheme.colors.secondary,
        )
    }
}

@Composable
private fun WelcomeBackground(backgroundResource: Int) {

    Image(
        painterResource(id = backgroundResource),
        contentDescription = "null",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}

@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
private fun WelcomeScreenPreview() {
    MyTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            WelcomeScreen()
        }
    }
}
