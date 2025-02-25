package ks.connecttooffice10.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ks.connecttooffice10.ui.mapper.MapperDomainToUi

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    fun provideMapperDomainToUi(): MapperDomainToUi {
        return MapperDomainToUi()
    }
}