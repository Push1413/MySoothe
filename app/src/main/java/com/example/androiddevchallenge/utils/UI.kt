package com.example.androiddevchallenge.utils

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun MySootheTextField(
    label: String,
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null
) {
    val state = rememberSaveable {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = state.value,
        onValueChange = {
            state.value = it
        },
        label = {
            Text(text = label)
        },
        modifier = modifier.fillMaxWidth(),
        leadingIcon = {
            if (leadingIcon != null) {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
fun MySootheButton(
    onClick: () -> Unit,
    buttonText: String,
    backgroundColor: androidx.compose.ui.graphics.Color = MaterialTheme.colors.primary
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(text = buttonText)
    }
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
private fun DefaultPreview() {
    MyTheme {
//        MySootheButton(
//            onClick = {},
//            buttonText = "Btn Test",
//            backgroundColor = MaterialTheme.colors.background
//        )
        MySootheTextField(
            label = "Test"
        )
    }
}
