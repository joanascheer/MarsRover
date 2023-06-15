package com.joana.marsrover.service

import com.joana.marsrover.service.model.RoverManifestRemoteModel
import retrofit2.http.GET
import retrofit2.http.Path

interface MarsRoverManifestService {

    @GET
    suspend fun getMarsRoverManifest(@Path("rover_name") roverName: String): RoverManifestRemoteModel
}