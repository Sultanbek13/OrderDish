package com.sultandev.feature_main.di

import com.sultandev.feature_main.navigation.NavigatorMain
import com.sultandev.feature_category.navigation.CategoryNavigation
import com.sultandev.feature_product.navigation.ProductNavigation
import org.koin.dsl.binds
import org.koin.dsl.module

object NavigationMain {
    val module = module {
        single { NavigatorMain() } binds arrayOf(
            CategoryNavigation::class,
            ProductNavigation::class
        )
    }
}