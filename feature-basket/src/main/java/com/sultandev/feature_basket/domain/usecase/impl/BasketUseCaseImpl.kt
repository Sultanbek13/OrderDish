package com.sultandev.feature_basket.domain.usecase.impl

import com.sultandev.core_database.entity.ProductEntity
import com.sultandev.feature_basket.domain.repository.BasketRepository
import com.sultandev.feature_basket.domain.usecase.BasketUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

internal class BasketUseCaseImpl(private val basketRepository: BasketRepository) : BasketUseCase {

    override fun invoke(): Flow<List<ProductEntity>> = basketRepository.getAllBasketProduct()

    override suspend fun invoke(productEntity: ProductEntity) = basketRepository.updateProduct(productEntity)

}