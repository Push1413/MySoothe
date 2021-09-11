package com.example.androiddevchallenge.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.*
import com.example.androiddevchallenge.navigation.BottomNavigation1
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.utils.AlignYourBodyRow
import com.example.androiddevchallenge.utils.FavoriteCollectionRow
import com.example.androiddevchallenge.utils.MySootheTextField

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomNavigation1()
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Default.PlayArrow,
                    contentDescription = null,
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true
    ) {
        HomeScreenContent(
            modifier = Modifier.padding(it),
            navController
        )
    }
}

@Composable
private fun HomeScreenContent(
    modifier: Modifier,
    navController:NavController
) {
    Column(
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        SearchBox()

        FavoriteCollectionBox()

        AlignBodyBox()

        Spacer(modifier = Modifier.height(8.dp))

        AlignMindBox()
    }
}

@Composable
private fun AlignMindBox() {
    Text(
        "ALIGN YOUR MIND",
        modifier = Modifier
            .paddingFromBaseline(40.dp)
            .padding(horizontal = 16.dp)
    )

    Spacer(modifier = Modifier.height(8.dp))

    AlignYourBodyRow(
        collections = alignYourMindCollections
    )
}

@Composable
private fun AlignBodyBox() {
    Text(
        "ALIGN YOUR BODY",
        modifier = Modifier
            .paddingFromBaseline(40.dp)
            .padding(horizontal = 16.dp)
    )

    Spacer(modifier = Modifier.height(8.dp))

    AlignYourBodyRow(
        collections = alignYourBodyCollections
    )
}


@Composable
private fun FavoriteCollectionBox() {
    Text(
        "FAVORITE COLLECTIONS",
        modifier = Modifier
            .paddingFromBaseline(40.dp)
            .padding(horizontal = 16.dp)
    )

    Spacer(modifier = Modifier.height(8.dp))

    FavoriteCollectionRow(
        collections = favoriteCollectionsOne
    )

    Spacer(modifier = Modifier.height(8.dp))

    FavoriteCollectionRow(
        collections = favoriteCollectionsTwo
    )
}

@Composable
private fun SearchBox() {
    MySootheTextField(
        label = "Search",
        leadingIcon = Icons.Default.Search,
        modifier = Modifier.padding(horizontal = 16.dp)
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
private fun DefaultPreview() {
    MyTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            HomeScreen(navController = rememberNavController())
        }

    }
}