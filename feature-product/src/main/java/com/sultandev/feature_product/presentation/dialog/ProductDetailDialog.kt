package com.sultandev.feature_product.presentation.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.bumptech.glide.Glide
import com.sultandev.core_util.toRub
import com.sultandev.core_util.toWight
import com.sultandev.feature_product.data.model.Product
import com.sultandev.feature_product.databinding.DialogProductDetailBinding

internal class ProductDetailDialog(context: Context, private val product: Product): Dialog(context) {

    private lateinit var binding: DialogProductDetailBinding

    private var onClickAddBasket: (() -> Unit)? = null

    fun setOnClickAddBasketListener(block: () -> Unit) {
        onClickAddBasket = block
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setCancelable(false)
        binding.apply {

            Glide
                .with(binding.root)
                .load(product.image_url)
                .into(imgProductDetail)

            tvNameProduct.text = product.name
            tvPriceProduct.text = product.price.toString().toRub()
            tvWeightProduct.text = product.weight.toString().toWight()
            tvRecipeProduct.text = product.description

            addBasket.setOnClickListener {
                onClickAddBasket?.invoke()
            }
        }
    }
}