package com.sultandev.feature_product.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface AdapterDelegate<T> {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    fun onBindViewHolder(item: T, viewHolder: RecyclerView.ViewHolder)
    fun isForItemType(item: Any): Boolean
}