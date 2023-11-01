package kr.pe.paran.kbank.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kr.pe.paran.kbank.common.utils.DatabaseConvert

@Database(
    entities = [],
    version = 1,
    exportSchema = false
)
@TypeConverters(DatabaseConvert::class)
abstract class Database: RoomDatabase() {

}