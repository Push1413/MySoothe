package com.example.mysoothe.utils

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mysoothe.data.Collection
import com.example.mysoothe.data.alignYourBodyCollections
import com.example.mysoothe.data.favoriteCollectionsOne
import com.example.mysoothe.ui.theme.MyTheme

@Composable
fun FavoriteCollectionRow(
    collections: List<Collection>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(collections) { collection ->
            CollectionRowItem(collection = collection)
        }
    }
}

@Composable
fun AlignYourBodyRow(collections: List<Collection>) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(collections) { collection ->
            AlignRowItem(collection)
        }
    }
}

@Composable
fun AlignRowItem(
    collection: Collection
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(color = MaterialTheme.colors.background)
    ) {
        Image(
            painterResource(id = collection.imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )

        Text(
            collection.name
        )
    }
}

@Composable
fun CollectionRowItem(
    collection: Collection
) {
    Card(
        modifier = Modifier.size(
            width = 192.dp,
            height = 56.dp
        ),
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(id = collection.imageRes),
                contentDescription = null,
                modifier = Modifier.size(56.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                collection.name,
                modifier = Modifier.weight(1F)
            )
        }
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
        Column {
            CollectionRowItem(
                collection = favoriteCollectionsOne.first()
            )
            AlignRowItem(
                collection = alignYourBodyCollections.first()
            )
        }
    }
}
