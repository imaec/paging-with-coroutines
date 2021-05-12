package com.imaec.pagingwithcoroutine.datasource

import androidx.paging.DataSource
import com.imaec.pagingwithcoroutine.model.Passenger
import com.imaec.pagingwithcoroutine.repository.MainRepository
import kotlinx.coroutines.CoroutineScope

class MainDataFactory(
    private val repository: MainRepository,
    private val scope: CoroutineScope
) : DataSource.Factory<Int, Passenger.Data>() {

    override fun create(): DataSource<Int, Passenger.Data> {
        return MainDataSource(repository, scope)
    }
}