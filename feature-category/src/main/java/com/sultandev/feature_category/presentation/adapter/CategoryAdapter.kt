package com.sultandev.feature_category.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sultandev.feature_category.R
import com.sultandev.feature_category.data.model.Category
import com.sultandev.feature_category.databinding.ItemCategoryBinding

internal class CategoryAdapter : ListAdapter<Category, CategoryAdapter.ViewHolder>(CategoryAdapterCompressor) {

    private var onCategoryListener: ((String) -> Unit)? = null

    fun setOnCategoryListener(block: (String) -> Unit) {
        onCategoryListener = block
    }

    inner class ViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onCategoryListener?.invoke(getItem(absoluteAdapterPosition).name ?: "")
            }
        }

        fun bind() {
            binding.apply {
                nameCategory.text = getItem(absoluteAdapterPosition).name
                Glide
                    .with(binding.root.context)
                    .load(getItem(absoluteAdapterPosition).image_url)
                    .into(imgCategory)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCategoryBinding.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()

}

internal object CategoryAdapterCompressor : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.id == newItem.id &&
                oldItem.name == newItem.name &&
                oldItem.image_url == newItem.image_url
    }
}