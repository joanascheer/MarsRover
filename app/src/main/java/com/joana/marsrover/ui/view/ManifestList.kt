package com.joana.marsrover.ui.view

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joana.marsrover.R
import com.joana.marsrover.domain.model.RoverManifestUiModel

@Composable
fun ManifestList(
    modifier: Modifier,
    roverManifestUiModelList: List<RoverManifestUiModel>,
    roverName: String,
    onClick: (roverName: String, sol: String) -> Unit
) {
    Surface(color = MaterialTheme.colorScheme.background, modifier = modifier.fillMaxSize()) {
        LazyColumn {
            items(count = roverManifestUiModelList.size, itemContent = {
                Manifest(roverManifestUiModel = roverManifestUiModelList[it], roverName, onClick)
            })
        }

    }
}

@Composable
fun Manifest(
    roverManifestUiModel: RoverManifestUiModel,
    roverName: String,
    onClick: (roverName: String, sol: String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable {
                onClick(roverName, roverManifestUiModel.sol)
            }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = stringResource(id = R.string.sol, roverManifestUiModel.sol))
            Text(text = stringResource(id = R.string.earthDate, roverManifestUiModel.earthDate))
            Text(text = stringResource(id = R.string.photoNumber, roverManifestUiModel.photoNumber))
        }
    }
}

@Preview
@Composable
fun ManifestsPreview() {
    Manifest(roverManifestUiModel = RoverManifestUiModel(
        "4",
        "22/12/1986",
        "1"),
        roverName = "",
        onClick = { _, _ -> })
}