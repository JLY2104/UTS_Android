package com.example.unscramble.data
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun InsertWord(word: Words)

    @Query("SELECT * FROM words_data ORDER BY words ASC")
    fun getAllWords(): Flow<List<Words>>
}