package com.joana.marsrover.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joana.marsrover.R
import com.joana.marsrover.domain.model.roverList


@Composable
fun RoverList(
    modifier: Modifier,
    onClick: (roverName: String) -> Unit
) {
    Surface(color = MaterialTheme.colorScheme.background, modifier = modifier.fillMaxSize()) {
        LazyColumn {
            items(count = roverList.size, itemContent = { index ->
                Rover(
                    name = roverList[index].name,
                    img = roverList[index].img,
                    landingDate = roverList[index].landingDate,
                    distance = roverList[index].distance,
                    onClick = onClick
                )
            })
        }
        
    }
}

@Preview
@Composable
fun RoverPreview() {
    Rover(
        name = "Perseverance",
        img = R.drawable.mr1,
        landingDate = "04 março 2012",
        distance = "11.56 km",
    ) {

    }
}

@Composable
fun Rover(
    name: String,
    img: Int,
    landingDate: String,
    distance: String,
    onClick: (roverName: String) -> Unit
) {
    Card(modifier = Modifier
        .padding(16.dp)
        .clickable { onClick(name) }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
            )
            Image(painter = painterResource(id = img), contentDescription = null )
            Text(text = "Credit: NASA/JPL", fontSize = 8.sp)
            Text(text = "Landing date: $landingDate", fontSize = 12.sp)
            Text(text = "Distance: $distance", fontSize = 12.sp)
        }
    }
}

