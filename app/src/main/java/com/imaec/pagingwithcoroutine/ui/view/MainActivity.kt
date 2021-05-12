package com.imaec.pagingwithcoroutine.ui.view

import android.os.Bundle
import com.imaec.pagingwithcoroutine.Extensions.getViewModel
import com.imaec.pagingwithcoroutine.R
import com.imaec.pagingwithcoroutine.base.BaseActivity
import com.imaec.pagingwithcoroutine.databinding.ActivityMainBinding
import com.imaec.pagingwithcoroutine.repository.MainRepository
import com.imaec.pagingwithcoroutine.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val repository by lazy { MainRepository() }
    private val viewModel by lazy { getViewModel { MainViewModel(repository) } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel
    }
}