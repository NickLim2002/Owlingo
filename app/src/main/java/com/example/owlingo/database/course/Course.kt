package com.example.owlingo.database.course

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "course")
data class Course(

    @PrimaryKey(autoGenerate = true)
    var courseId: Long = 0L,

   

    )