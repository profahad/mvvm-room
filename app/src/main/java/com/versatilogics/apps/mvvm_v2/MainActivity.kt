package com.versatilogics.apps.mvvm_v2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.versatilogics.apps.mvvm_v2.databinding.ActivityMainBinding
import com.versatilogics.apps.mvvm_v2.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    private lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupListeners()
        setupObservers()
        loadDirector(2)
    }

    private fun setupObservers() {
        viewModel.directorList.observe(this, {
            dataBinding.textView.text = it.joinToString(separator = ", ")
        })
    }

    private fun setupListeners() {

    }

    private fun loadDirector(id: Long) {
        viewModel.findDirectorWithMovies(id).observe(this, {
            dataBinding.textView.text = "${dataBinding.textView.text}\n$it"
        })
    }
}