package com.joana.marsrover.di

import com.joana.marsrover.service.MarsRoverManifestService
import com.joana.marsrover.service.model.MarsRoverPhotoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideMarsRoverManifestService(): MarsRoverManifestService =
        MarsRoverManifestService.create()

    @Provides
    fun provideMarsRoverPhotoService(): MarsRoverPhotoService =
        MarsRoverPhotoService.create()
}
