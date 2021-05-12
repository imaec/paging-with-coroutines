package com.imaec.pagingwithcoroutine.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.imaec.pagingwithcoroutine.base.BasePagedAdapter
import com.imaec.pagingwithcoroutine.databinding.ItemMainBinding
import com.imaec.pagingwithcoroutine.model.Passenger

class MainPagedListAdapter : BasePagedAdapter<Passenger.Data>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Passenger.Data>() {
            override fun areItemsTheSame(oldItem: Passenger.Data, newItem: Passenger.Data): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Passenger.Data, newItem: Passenger.Data): Boolean {
                return oldItem._id == newItem._id
                        && oldItem.name == newItem.name
                        && oldItem.trips == newItem.trips
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context))
        return ItemViewHolder(binding as ItemMainBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            holder.onBind(getItem(position) as Passenger.Data)
        }
    }

    inner class ItemViewHolder(private val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Passenger.Data) {
            binding.item = item
        }
    }
}