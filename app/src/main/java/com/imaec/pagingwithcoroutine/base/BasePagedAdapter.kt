package com.imaec.pagingwithcoroutine.base

import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BasePagedAdapter<T : Any>(
    DIFF_CALLBACK: DiffUtil.ItemCallback<T>
) : PagedListAdapter<T, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    protected lateinit var binding: ViewDataBinding
}