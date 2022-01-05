package com.example.simplediary

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Diary::class], version = 1)
abstract class DiaryDatabase: RoomDatabase() {

    abstract fun diaryDao(): DiaryDao

    companion object {
        private var INSTANCE: DiaryDatabase? = null

        fun getInstance(context: Context): DiaryDatabase? {
            if (INSTANCE == null) {
                synchronized(DiaryDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        DiaryDatabase::class.java, "diary")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }

}