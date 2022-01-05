package com.example.simplediary

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DiaryDao {

    @Query("SELECT * FROM diary ORDER BY title ASC")
    fun getAll(): LiveData<List<Diary>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(diary: Diary)

    @Delete
    fun delete(diary: Diary)

}