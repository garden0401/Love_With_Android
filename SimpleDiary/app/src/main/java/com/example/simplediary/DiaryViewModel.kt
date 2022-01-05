package com.example.simplediary

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class DiaryViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = DiaryRepository(application)
    private val diarys = repository.getAll()

    fun getAll(): LiveData<List<Diary>> {
        return this.diarys
    }

    fun insert(diary: Diary) {
        repository.insert(diary)
    }

    fun delete(diary: Diary) {
        repository.delete(diary)
    }
}