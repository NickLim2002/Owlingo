package com.example.owlingo.database.course

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "course")
data class Course(

    @PrimaryKey(autoGenerate = true)
    val course_id: Int=0,
    val course_name: String="",
    var course_detail: String="",
    var course_lecture: String="",
    var course_fee: Int=0,
    val couse_schedule: String="",


    )