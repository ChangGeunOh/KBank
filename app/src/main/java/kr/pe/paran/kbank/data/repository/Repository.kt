package kr.pe.paran.kbank.data.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kr.pe.paran.kbank.domain.repository.DataStoreDataSource
import kr.pe.paran.kbank.domain.repository.DatabaseDataSource
import kr.pe.paran.kbank.domain.repository.NetworkDataSource
import javax.inject.Inject

class Repository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val database: DatabaseDataSource,
    private val dataStore: DataStoreDataSource,
    private val network: NetworkDataSource,
) {

}