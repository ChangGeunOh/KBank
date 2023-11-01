package kr.pe.paran.kbank.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kr.pe.paran.kbank.data.datastore.dataStore
import kr.pe.paran.kbank.data.repository.DataStoreDataSourceImpl
import kr.pe.paran.kbank.domain.repository.DataStoreDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun provideDataStore(
        @ApplicationContext context: Context,
    ): DataStore<Preferences> = context.dataStore

    @Provides
    @Singleton
    fun provideDataStoreDataSource(
        dataStore: DataStore<Preferences>,
    ): DataStoreDataSource {
        return DataStoreDataSourceImpl(dataStore = dataStore)
    }
}