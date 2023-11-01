package kr.pe.paran.kbank.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kr.pe.paran.kbank.common.Constants
import kr.pe.paran.kbank.common.utils.DatabaseConvert
import kr.pe.paran.kbank.data.database.dao.TestDao
import kr.pe.paran.kbank.domain.model.TestData

@Database(
    entities = [TestData::class],
    version = Constants.DATABASE_VERSION,
    exportSchema = false
)
@TypeConverters(DatabaseConvert::class)
abstract class Database: RoomDatabase() {
    abstract fun testDao(): TestDao
}