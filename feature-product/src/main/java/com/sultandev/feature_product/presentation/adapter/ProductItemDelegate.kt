package com.sultandev.feature_product.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sultandev.feature_product.data.model.Product
import com.sultandev.feature_product.databinding.ItemProductBinding

internal class ProductItemDelegate : AdapterDelegate<Product> {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductItemViewHolder(binding)
    }

    override fun onBindViewHolder(item: Product, viewHolder: RecyclerView.ViewHolder) {
        val productItemViewHolder = viewHolder as ProductItemViewHolder
        productItemViewHolder.bind(item)
    }

    override fun isForItemType(item: Any): Boolean {
        return item is Product
    }
}