package com.example.android_mvvm_with_roomdatabase_and_dagger_hilt.ViewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.android_mvvm_with_roomdatabase_and_dagger_hilt.Model.User
import com.example.android_mvvm_with_roomdatabase_and_dagger_hilt.Repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserViewModel @Inject constructor(private val userRepository: UserRepository)
    : ViewModel() {
        val getUserData : LiveData<List<User>> = userRepository.getUserData
            .flowOn(Dispatchers.Main).asLiveData(context = viewModelScope.coroutineContext)


    fun insert(user : User) = viewModelScope.launch {
        userRepository.insert(user)
    }
}