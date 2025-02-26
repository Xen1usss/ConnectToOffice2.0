package ks.connecttooffice10.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ks.connecttooffice10.data.LoadDocumentsUseCase
import ks.connecttooffice10.data.MockLoadDocumentsUseCase

@Module
@InstallIn(SingletonComponent::class)
interface ApiModule {

    @Binds
    fun provideLoadUseCase(mockImpl : MockLoadDocumentsUseCase) : LoadDocumentsUseCase
}