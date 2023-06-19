package com.sultandev.feature_product.presentation.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sultandev.feature_product.data.model.Product
import com.sultandev.feature_product.domain.usecase.ProductUseCase
import com.sultandev.feature_product.presentation.viewmodel.ProductViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

internal class ProductViewModelImpl(private val productUseCase: ProductUseCase) : ProductViewModel,
    ViewModel() {

    override val allProduct: MutableSharedFlow<List<Product>> = MutableSharedFlow()

    override val message: MutableSharedFlow<String> = MutableSharedFlow()

    override val addBasket: MutableSharedFlow<Unit> = MutableSharedFlow()

    override val allTags: MutableSharedFlow<List<String>> = MutableSharedFlow()

    override fun getProductsByTag(tag: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = productUseCase.invoke(tag)
            try {
                if(result.isSuccess) {
                    allProduct.emit(result.data)
                } else {
                    message.emit(result.error)
                }
            } catch (e: Exception) {
                message.emit(e.message ?: "Unknown error")
            }
        }
    }

    override fun getAllTags() {
        viewModelScope.launch {
            val result = productUseCase.getTags()
            allTags.emit(result)
        }
    }

    override fun onAddBasket(product: Product) {
        viewModelScope.launch {
            productUseCase.invoke(product)
        }
    }
}