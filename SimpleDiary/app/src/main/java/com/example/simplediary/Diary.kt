package com.example.simplediary

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diary")
data class Diary(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "content")
    var content: String,

    @ColumnInfo(name = "initial")
    var initial: Char
) {
    constructor() : this(null, "", "", '\u0000')
}