package kr.pe.paran.kbank.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.pe.paran.kbank.data.network.Network
import kr.pe.paran.kbank.data.repository.NetworkDataSourceImpl
import kr.pe.paran.kbank.domain.repository.NetworkDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideNetwork(): Network {
        return Network()
    }

    @Provides
    @Singleton
    fun provideNetworkDataSource(
        network: Network
    ): NetworkDataSource {
        return NetworkDataSourceImpl( network = network )
    }

}