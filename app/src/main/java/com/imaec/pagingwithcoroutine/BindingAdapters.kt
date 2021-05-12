package com.imaec.pagingwithcoroutine

import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.imaec.pagingwithcoroutine.model.Passenger
import com.imaec.pagingwithcoroutine.ui.adapter.MainPagedListAdapter

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("adapter")
    fun setAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) {
        recyclerView.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("items")
    fun setItems(recyclerView: RecyclerView, items: PagedList<Passenger.Data>?) {
        (recyclerView.adapter as MainPagedListAdapter).apply {
            submitList(items)
        }
    }
}