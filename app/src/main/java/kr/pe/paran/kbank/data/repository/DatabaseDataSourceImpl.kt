package kr.pe.paran.kbank.data.repository

import kr.pe.paran.kbank.data.database.Database
import kr.pe.paran.kbank.domain.repository.DatabaseDataSource
import javax.inject.Inject

class DatabaseDataSourceImpl @Inject constructor(
    private val database: Database,
) : DatabaseDataSource {

}