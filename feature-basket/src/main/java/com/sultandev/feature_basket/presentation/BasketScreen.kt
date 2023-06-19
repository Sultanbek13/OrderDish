package com.sultandev.feature_basket.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.sultandev.feature_basket.R
import com.sultandev.feature_basket.databinding.ScreenBasketBinding
import com.sultandev.feature_basket.presentation.adapter.BasketProductAdapter
import com.sultandev.feature_basket.presentation.viewmodel.impl.BasketViewModelImpl
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class BasketScreen: Fragment(R.layout.screen_basket) {

    private val binding: ScreenBasketBinding by viewBinding()
    private val viewModel: BasketViewModelImpl by viewModel()
    private val adapter by lazy(LazyThreadSafetyMode.NONE) { BasketProductAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvBasket.adapter = adapter

        viewModel.allBasketProduct.onEach {
            binding.payProducts.isVisible = it.isNotEmpty()
            adapter.submitList(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        adapter.setOnUpdateProduct { product, pos ->
            viewModel.updateProduct(product)
            adapter.notifyItemChanged(pos)
        }

        viewModel.getAllBasketProduct()

    }
}