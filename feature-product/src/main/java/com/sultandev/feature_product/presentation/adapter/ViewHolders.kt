package com.sultandev.feature_product.presentation.adapter

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sultandev.feature_product.R
import com.sultandev.feature_product.data.model.Product
import com.sultandev.feature_product.databinding.ItemProductBinding
import com.sultandev.feature_product.databinding.ItemTagBinding

internal class ProductItemViewHolder(private val binding: ItemProductBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private var onItemClickListener: ((Product) -> Unit)? = null

    fun setOnItemClickListener(listener: (Product) -> Unit) {
        onItemClickListener = listener
    }

    fun bind(item: Product) {
        binding.apply {
            nameProduct.text = item.name
            Glide
                .with(binding.root.context)
                .load(item.image_url)
                .into(imgProduct)

            root.setOnClickListener {
                onItemClickListener?.invoke(item)
            }
        }
    }
}

var selectedIndex = 0

internal class TagItemViewHolder(private val binding: ItemTagBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private var onItemClickListener: ((String, Int, Int) -> Unit)? = null

    fun setOnItemClickListener(listener: (String, Int, Int) -> Unit) {
        onItemClickListener = listener
    }

    fun bind(item: String) {
        binding.apply {
            tvTag.text = item

            llTag.setBackgroundResource(R.drawable.bg_tag_def)
            tvTag.setTextColor(Color.parseColor("#FF000000"))

            if (selectedIndex == absoluteAdapterPosition) {
                llTag.setBackgroundResource(R.drawable.bg_tag_selected)
                tvTag.setTextColor(Color.parseColor("#FFFFFFFF"));
            }

            root.setOnClickListener {
                val previousSelectedItemPosition = selectedIndex
                selectedIndex = absoluteAdapterPosition
                onItemClickListener?.invoke(
                    item,
                    absoluteAdapterPosition,
                    previousSelectedItemPosition
                )
            }
        }
    }
}
