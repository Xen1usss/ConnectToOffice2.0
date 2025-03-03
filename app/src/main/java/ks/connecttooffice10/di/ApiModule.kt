package ks.connecttooffice10.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ks.connecttooffice10.data.AuthRepository
import ks.connecttooffice10.data.AuthRepositoryImpl
import ks.connecttooffice10.data.FilesRepository
import ks.connecttooffice10.data.FilesRepositoryImpl
import ks.connecttooffice10.domain.LoadDocumentsUseCase
import ks.connecttooffice10.domain.LoadFilesUseCase
import ks.connecttooffice10.domain.LoginUseCase
import ks.connecttooffice10.domain.LoginUseCaseImpl
import ks.connecttooffice10.domain.MockLoadDocumentsUseCase

@Module
@InstallIn(SingletonComponent::class)
interface ApiModule {

    @Binds
    fun provideLoadUseCase(impl : LoadFilesUseCase) : LoadDocumentsUseCase

    @Binds
    fun provideLoginUseCase(impl : LoginUseCaseImpl) : LoginUseCase

    @Binds
    fun provideLoginRepository(impl : AuthRepositoryImpl) : AuthRepository

    @Binds
    fun provideFilesRepository(impl : FilesRepositoryImpl) : FilesRepository
}