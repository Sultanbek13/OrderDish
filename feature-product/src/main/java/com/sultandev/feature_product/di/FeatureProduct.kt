package com.sultandev.feature_product.di

import com.sultandev.feature_product.data.netowork.ListProduct
import com.sultandev.feature_product.data.repositroy.ProductRepositoryImpl
import com.sultandev.feature_product.domain.repository.ProductRepository
import com.sultandev.feature_product.domain.usecase.ProductUseCase
import com.sultandev.feature_product.domain.usecase.impl.ProductUseCaseImpl
import com.sultandev.feature_product.presentation.viewmodel.impl.ProductViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

object FeatureProduct {

    val module = module {

        single { get<Retrofit>().create(ListProduct::class.java) }

        single<ProductRepository> { ProductRepositoryImpl(get(), get()) }

        single<ProductUseCase> { ProductUseCaseImpl(get()) }

        viewModel { ProductViewModelImpl(get()) }

    }
}