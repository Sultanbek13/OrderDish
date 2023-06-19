package com.sultandev.feature_category.di

import com.sultandev.feature_category.data.network.ListCategories
import com.sultandev.feature_category.data.repository.CategoryRepositoryImpl
import com.sultandev.feature_category.domain.repository.CategoryRepository
import com.sultandev.feature_category.domain.usecase.CategoryUseCase
import com.sultandev.feature_category.domain.usecase.impl.CategoryUseCaseImpl
import com.sultandev.feature_category.presentation.viewmodel.impl.CategoryViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

object FeatureCategory {
    val module = module {

        single { get<Retrofit>().create(ListCategories::class.java) }

        single<CategoryRepository> { CategoryRepositoryImpl(get()) }

        single<CategoryUseCase> { CategoryUseCaseImpl(get()) }

        viewModel { CategoryViewModelImpl(get()) }

    }
}