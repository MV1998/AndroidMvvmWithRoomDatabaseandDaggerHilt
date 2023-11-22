package com.example.android_mvvm_with_roomdatabase_and_dagger_hilt.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android_mvvm_with_roomdatabase_and_dagger_hilt.Dao.UserDao
import com.example.android_mvvm_with_roomdatabase_and_dagger_hilt.Model.User


@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao
}