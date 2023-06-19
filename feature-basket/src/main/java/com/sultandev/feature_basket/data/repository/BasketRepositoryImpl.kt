package com.sultandev.feature_basket.data.repository

import com.sultandev.core_database.dao.ProductDao
import com.sultandev.core_database.entity.ProductEntity
import com.sultandev.feature_basket.domain.repository.BasketRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.flow

class BasketRepositoryImpl(private val productDao: ProductDao): BasketRepository {

    override fun getAllBasketProduct(): Flow<List<ProductEntity>> = productDao.getAllBasketProduct()

    override suspend fun updateProduct(productEntity: ProductEntity) = productDao.update(productEntity)

}