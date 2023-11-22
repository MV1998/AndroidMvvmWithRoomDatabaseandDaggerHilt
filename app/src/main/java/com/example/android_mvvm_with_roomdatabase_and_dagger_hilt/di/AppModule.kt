package com.example.android_mvvm_with_roomdatabase_and_dagger_hilt.di

import android.content.Context
import android.service.autofill.UserData
import androidx.room.Room
import com.example.android_mvvm_with_roomdatabase_and_dagger_hilt.Dao.UserDao
import com.example.android_mvvm_with_roomdatabase_and_dagger_hilt.Database.UserDatabase
import com.example.android_mvvm_with_roomdatabase_and_dagger_hilt.Repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : UserDatabase =
        Room.databaseBuilder(context, UserDatabase::class.java, "userDatabase")
            .build()

    @Provides
    fun provideUserDao(userDatabase: UserDatabase) : UserDao =
        userDatabase.userDao()

    @Provides
    fun provideUserRepository(userDao: UserDao) : UserRepository =
        UserRepository(userDao)
}