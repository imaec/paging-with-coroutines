package com.imaec.pagingwithcoroutine.datasource

import androidx.paging.PageKeyedDataSource
import com.imaec.pagingwithcoroutine.model.Passenger
import com.imaec.pagingwithcoroutine.repository.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainDataSource(
    private val repository: MainRepository,
    private val scope: CoroutineScope
) : PageKeyedDataSource<Int, Passenger.Data>() {

    private var totalPage = 0

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Passenger.Data>
    ) {
        val curPage = 1
        val nextPage = curPage + 1

        scope.launch {
            val response = repository.getData(curPage, params.requestedLoadSize)
            totalPage = response.totalPages
            callback.onResult(response.data, null, nextPage)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Passenger.Data>) {
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Passenger.Data>) {
        if (totalPage < params.key) return

        scope.launch {
            val response = repository.getData(params.key, params.requestedLoadSize)
            val nextPage = params.key + 1

            totalPage = response.totalPages
            callback.onResult(response.data, nextPage)
        }
    }

    override fun invalidate() {
        super.invalidate()
        scope.cancel()
    }
}