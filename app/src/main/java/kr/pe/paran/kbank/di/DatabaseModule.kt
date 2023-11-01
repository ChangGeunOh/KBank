package kr.pe.paran.kbank.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kr.pe.paran.kbank.common.Constants
import kr.pe.paran.kbank.data.database.Database
import kr.pe.paran.kbank.data.repository.DatabaseDataSourceImpl
import kr.pe.paran.kbank.domain.repository.DatabaseDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext
        context: Context
    ): Database {
        return Room
            .databaseBuilder(
                context,
                Database::class.java,
                Constants.DATABASE_NAME
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDatabaseDataSource(
        database: Database
    ): DatabaseDataSource {
        return DatabaseDataSourceImpl(database)
    }
}