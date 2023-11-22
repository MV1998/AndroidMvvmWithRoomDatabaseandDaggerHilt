package com.example.android_mvvm_with_roomdatabase_and_dagger_hilt.Repository

import com.example.android_mvvm_with_roomdatabase_and_dagger_hilt.Dao.UserDao
import com.example.android_mvvm_with_roomdatabase_and_dagger_hilt.Model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao) {
    val getUserData : Flow<List<User>> = userDao.getUser()

    suspend fun insert(user : User) = withContext(Dispatchers.IO) {
        userDao.insert(user)
    }
}