package com.sultandev.feature_basket.di

import com.sultandev.feature_basket.data.repository.BasketRepositoryImpl
import com.sultandev.feature_basket.domain.repository.BasketRepository
import com.sultandev.feature_basket.domain.usecase.BasketUseCase
import com.sultandev.feature_basket.domain.usecase.impl.BasketUseCaseImpl
import com.sultandev.feature_basket.presentation.viewmodel.impl.BasketViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object FeatureBasket {

    val module = module {

        single<BasketRepository> { BasketRepositoryImpl(get()) }

        single<BasketUseCase> { BasketUseCaseImpl(get()) }

        viewModel { BasketViewModelImpl(get()) }

    }
}