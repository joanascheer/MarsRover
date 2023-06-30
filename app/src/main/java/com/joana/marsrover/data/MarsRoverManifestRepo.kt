package com.joana.marsrover.data

import com.joana.marsrover.domain.model.RoverManifestUiState
import com.joana.marsrover.domain.model.toUiModel
import com.joana.marsrover.service.MarsRoverManifestService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarsRoverManifestRepo @Inject constructor(
    private val marsRoverManifestService: MarsRoverManifestService
) {

    fun getMarsRoverManifest(roverName: String): Flow<RoverManifestUiState> = flow {
        try {
            emit(
                toUiModel(
                    marsRoverManifestService.getMarsRoverManifest(
                        roverName.lowercase()
                    )
                )
            )
        } catch (tr: Throwable) {
            emit(RoverManifestUiState.Error)
        }
    }
}