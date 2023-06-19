package com.sultandev.feature_category.domain.usecase

import com.sultandev.core_network.di.model.NetworkResponse
import com.sultandev.feature_category.data.model.Categories
import com.sultandev.feature_category.data.model.Category

internal interface CategoryUseCase {

    suspend operator fun invoke(): NetworkResponse<List<Category>>

}