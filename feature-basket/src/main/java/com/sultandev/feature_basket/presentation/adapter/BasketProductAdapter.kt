package com.sultandev.feature_basket.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sultandev.core_database.entity.ProductEntity
import com.sultandev.core_util.toRub
import com.sultandev.core_util.toWight
import com.sultandev.feature_basket.R
import com.sultandev.feature_basket.databinding.ItemBasketBinding

internal class BasketProductAdapter :
    ListAdapter<ProductEntity, BasketProductAdapter.ViewHolder>(BasketProductAdapterCompressor) {

    private var onUpdateProduct: ((ProductEntity, Int) -> Unit)? = null

    fun setOnUpdateProduct(block: (ProductEntity, Int) -> Unit) {
        onUpdateProduct = block
    }

    inner class ViewHolder(private val binding: ItemBasketBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            binding.apply {
                tvNameBasket.text = getItem(absoluteAdapterPosition).name
                tvPriceBasket.text = getItem(absoluteAdapterPosition).price.toString().toRub()
                tvWeightBasket.text = getItem(absoluteAdapterPosition).weight.toString().toWight()
                dishCount.text = getItem(absoluteAdapterPosition).count.toString()

                Glide
                    .with(binding.root.context)
                    .load(getItem(absoluteAdapterPosition).image_url)
                    .into(imgBasket)

                plusDishCount.setOnClickListener {
                    getItem(absoluteAdapterPosition).count += 1
                    onUpdateProduct?.invoke(getItem(absoluteAdapterPosition), absoluteAdapterPosition)
                }

                minusDishCount.setOnClickListener {
                    val product = getItem(absoluteAdapterPosition)
                    if (product.count >= 1) {
                        if (product.count <= 1) product.count = 0
                        else product.count -= 1
                        onUpdateProduct?.invoke(
                            product,
                            absoluteAdapterPosition
                        )
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBasketBinding.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.item_basket, parent, false)
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()

}

internal object BasketProductAdapterCompressor : DiffUtil.ItemCallback<ProductEntity>() {
    override fun areItemsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean {
        return oldItem.id == newItem.id &&
                oldItem.name == newItem.name &&
                oldItem.image_url == newItem.image_url
    }
}