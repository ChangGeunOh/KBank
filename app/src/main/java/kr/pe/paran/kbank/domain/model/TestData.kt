package kr.pe.paran.kbank.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test")
data class TestData(
    @PrimaryKey(autoGenerate = true)
    val idx: Int = 0,
)
