package com.example.owlingo.database.payment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "payment")
data class Payment(

    @PrimaryKey(autoGenerate = true)
    val payment_id: Int=0,
    val user_id: Int=0,
    val amount: String="",
    val payment_DateTime: String="",
    val payment_method: String="",


)