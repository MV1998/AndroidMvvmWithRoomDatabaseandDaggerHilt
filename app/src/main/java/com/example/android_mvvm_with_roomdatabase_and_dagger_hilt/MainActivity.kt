package com.example.android_mvvm_with_roomdatabase_and_dagger_hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_mvvm_with_roomdatabase_and_dagger_hilt.Adapters.UserAdapter
import com.example.android_mvvm_with_roomdatabase_and_dagger_hilt.Model.User
import com.example.android_mvvm_with_roomdatabase_and_dagger_hilt.ViewModel.UserViewModel
import com.example.android_mvvm_with_roomdatabase_and_dagger_hilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private val userViewModel : UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initRecyclerView()
        userViewModel.getUserData.observe(this, Observer {
            userAdapter.setData(it as ArrayList<User>)
        })

        binding.saveBtn.setOnClickListener {
            val name = binding.nameEditTextId.text.toString().trim()
            val age = binding.ageEditTextId.text.toString().trim()

            if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(age)) {
                val user = User(name, age.toInt())
                userViewModel.insert(user)
            }else {
                Toast.makeText(this@MainActivity, "Please enter values.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun initRecyclerView() {
        userAdapter = UserAdapter(this@MainActivity, ArrayList())
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
    }
}