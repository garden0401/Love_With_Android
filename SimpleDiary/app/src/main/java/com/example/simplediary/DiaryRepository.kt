package com.example.simplediary

import android.app.Application
import androidx.lifecycle.LiveData

class DiaryRepository(application: Application) {

    private val diaryDatabase = DiaryDatabase.getInstance(application)!!
    private val diaryDao: DiaryDao = diaryDatabase.diaryDao()
    private val diarys: LiveData<List<Diary>> = diaryDao.getAll()

    fun getAll(): LiveData<List<Diary>> {
        return diarys
    }

    fun insert(diary: Diary) {
        try {
            val thread = Thread(Runnable {
                diaryDao.insert(diary) })
            thread.start()
        } catch (e: Exception) { }
    }

    fun delete(diary: Diary) {
        try {
            val thread = Thread(Runnable {
                diaryDao.delete(diary)
            })
            thread.start()
        } catch (e: Exception) { }
    }

}