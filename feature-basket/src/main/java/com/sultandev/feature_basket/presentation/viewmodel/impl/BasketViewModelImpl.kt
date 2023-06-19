package com.sultandev.feature_basket.presentation.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sultandev.core_database.entity.ProductEntity
import com.sultandev.feature_basket.domain.usecase.BasketUseCase
import com.sultandev.feature_basket.presentation.viewmodel.BasketViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

internal class BasketViewModelImpl(private val basketUseCase: BasketUseCase) : BasketViewModel,
    ViewModel() {

    override val allBasketProduct: MutableSharedFlow<List<ProductEntity>> = MutableSharedFlow()

    override val message: MutableSharedFlow<String> = MutableSharedFlow()

    override fun getAllBasketProduct() {
        viewModelScope.launch {
            val result = basketUseCase.invoke()
            try {
                result.collectLatest {
                    allBasketProduct.emit(it)
                }
            } catch (e: Exception) {
                message.emit(e.message ?: "Unknown error")
            }
        }
    }

    override fun updateProduct(productEntity: ProductEntity) {
        viewModelScope.launch {
            basketUseCase.invoke(productEntity)
        }
    }
}