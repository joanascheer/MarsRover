package com.joana.marsrover.data

import com.joana.marsrover.domain.model.RoverPhotoUiModel
import com.joana.marsrover.domain.model.RoverPhotoUiState
import com.joana.marsrover.service.model.MarsRoverPhotoService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarsRoverPhotoRepo @Inject constructor(
    private val marsRoverPhotoService: MarsRoverPhotoService
) {

    fun getMarsRoverPhoto(roverName: String, sol: String) : Flow<RoverPhotoUiState> = flow {
        try {
            val networkResult = marsRoverPhotoService.getMarsRoverPhoto(roverName, sol)
            emit(RoverPhotoUiState.Success(networkResult.photos.map { photo ->
                RoverPhotoUiModel(
                    id = photo.id,
                    roverName = photo.rover.name,
                    imgSrc = photo.imgSrc,
                    sol = photo.sol.toString(),
                    earthDate = photo.earthDate,
                    cameraFullName = photo.camera.fullName
                )
            }))
        } catch (throwable: Throwable) {
            emit(RoverPhotoUiState.Error)
        }
    }
}