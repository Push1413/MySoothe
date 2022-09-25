package com.example.mysoothe.navigation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable

@Composable
fun BottomNavigation1() {
    BottomAppBar(
        backgroundColor = MaterialTheme.colors.background,
    ) {
        BottomNavigationItem(
            selected = true,
            onClick = {},
            icon = {
                Icon(
                    Icons.Default.Spa,
                    contentDescription = null,
                )
            },
            label = {
                Text("HOME")
            }
        )

        BottomNavigationItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    Icons.Default.AccountCircle,
                    contentDescription = null,
                )
            },
            label = {
                Text("PROFILE")
            }
        )
    }
}
