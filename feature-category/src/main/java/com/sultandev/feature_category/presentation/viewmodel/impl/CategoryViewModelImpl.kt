package com.sultandev.feature_category.presentation.viewmodel.impl

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sultandev.feature_category.data.model.Category
import com.sultandev.feature_category.domain.usecase.CategoryUseCase
import com.sultandev.feature_category.domain.usecase.impl.CategoryUseCaseImpl
import com.sultandev.feature_category.presentation.viewmodel.CategoryViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

internal class CategoryViewModelImpl(private val categoryUseCase: CategoryUseCase) :
    CategoryViewModel, ViewModel() {

    override val allCategories: MutableSharedFlow<List<Category>> = MutableSharedFlow()

    override val message: MutableSharedFlow<String> = MutableSharedFlow()

    override fun getAllCategories() {
        val result = categoryUseCase
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (result.invoke().isSuccess) {
                    allCategories.emit(result.invoke().data)
                } else {
                    message.emit(result.invoke().error)
                }
            } catch (e: Exception) {
                message.emit(e.message ?: "Unknown error")
            }
        }
    }
}