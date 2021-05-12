package com.imaec.pagingwithcoroutine.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.imaec.pagingwithcoroutine.base.BaseViewModel
import com.imaec.pagingwithcoroutine.datasource.MainDataFactory
import com.imaec.pagingwithcoroutine.model.Passenger
import com.imaec.pagingwithcoroutine.repository.MainRepository
import com.imaec.pagingwithcoroutine.ui.adapter.MainPagedListAdapter

class MainViewModel(
    private val repository: MainRepository
) : BaseViewModel() {

    private lateinit var pagedListBuilder: LivePagedListBuilder<Int, Passenger.Data>

    val adapter = MainPagedListAdapter()
    val list = getData()

    private fun getData(): LiveData<PagedList<Passenger.Data>> {
        val config = PagedList.Config.Builder()
            .setPageSize(30)
            .setPrefetchDistance(30)
            .setInitialLoadSizeHint(30)
            .setEnablePlaceholders(true)
            .build()
        val factory = MainDataFactory(repository, viewModelScope)
        pagedListBuilder = LivePagedListBuilder(factory, config)
        return pagedListBuilder.build()
    }
}