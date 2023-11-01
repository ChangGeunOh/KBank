package kr.pe.paran.kbank.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import kr.pe.paran.kbank.domain.repository.DataStoreDataSource
import javax.inject.Inject

class DataStoreDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
): DataStoreDataSource {
}