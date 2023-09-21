package com.example.owlingo.database.payment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "payment")
data class Payment(

    @PrimaryKey(autoGenerate = true)
    var paymentId: Long = 0L,



    )