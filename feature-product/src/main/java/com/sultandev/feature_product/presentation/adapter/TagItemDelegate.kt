package com.sultandev.feature_product.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sultandev.feature_product.databinding.ItemTagBinding

internal class TagItemDelegate : AdapterDelegate<String> {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = ItemTagBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TagItemViewHolder(binding)
    }

    override fun onBindViewHolder(item: String, viewHolder: RecyclerView.ViewHolder) {
        val tagItemViewHolder = viewHolder as TagItemViewHolder
        tagItemViewHolder.bind(item)
    }

    override fun isForItemType(item: Any): Boolean {
        return item is String
    }
}