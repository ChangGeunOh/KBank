package kr.pe.paran.kbank.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.pe.paran.kbank.data.repository.Repository
import kr.pe.paran.kbank.domain.use_case.UseCases
import kr.pe.paran.kbank.domain.use_case.test_case.TestCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCases(
        repository: Repository
    ): UseCases {
        return UseCases(
            testCase = TestCase(repository = repository),
        )
    }
}