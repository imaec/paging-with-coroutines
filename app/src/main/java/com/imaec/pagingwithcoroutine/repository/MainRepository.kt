package com.imaec.pagingwithcoroutine.repository

import com.imaec.pagingwithcoroutine.service.TestService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository {

    private val service by lazy { TestService.getInstance() }

    suspend fun getData(page: Int, size: Int) = withContext(Dispatchers.IO) {
        service.getData(page, size)
    }
}