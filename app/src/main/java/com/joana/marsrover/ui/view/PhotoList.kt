package com.joana.marsrover.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.joana.marsrover.R
import com.joana.marsrover.domain.model.RoverPhotoUiModel

@Composable
fun PhotoList(
    modifier: Modifier,
    roverPhotoUiModelList: List<RoverPhotoUiModel>
) {
    Surface(color = MaterialTheme.colorScheme.background, modifier = modifier.fillMaxSize()) {
        LazyColumn {
            items(count = roverPhotoUiModelList.size, itemContent = {
                Photo(roverPhotoUiModel = roverPhotoUiModelList[it])
            })
        }
    }

}

@Composable
fun Photo(
    roverPhotoUiModel: RoverPhotoUiModel
) {
    Card(
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = roverPhotoUiModel.roverName,
                modifier = Modifier.padding(16.dp)
            )

            AsyncImage(
                model = roverPhotoUiModel.imgSrc,
                contentDescription = "rover photo",
                modifier = Modifier.height(300.dp)
            )

            Text(text = stringResource(id = R.string.sol, roverPhotoUiModel.sol))
            Text(text = stringResource(id = R.string.earthDate, roverPhotoUiModel.earthDate))
            Text(text = roverPhotoUiModel.cameraFullName)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhotoPreview() {
    Photo(
        roverPhotoUiModel = RoverPhotoUiModel(
            id = 6,
            roverName = "Curiosity",
            imgSrc = "https://domain.com",
            sol = "36",
            earthDate = "22/12/1986",
            cameraFullName = "Parangaricotirimirruaro"
        )
    )
}