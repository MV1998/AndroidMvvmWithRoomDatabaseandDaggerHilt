package com.example.android_mvvm_with_roomdatabase_and_dagger_hilt.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(val name : String, val age : Int) {

    @PrimaryKey(autoGenerate = true)
    val id : Int? = null
}
