package com.sultandev.efftestingapp.di

import com.sultandev.efftestingapp.navigation.NavigatorGlobal
import com.sultandev.feature_category.navigation.CategoryNavigation
import org.koin.dsl.binds
import org.koin.dsl.module

object NavigationGlobal {
    val module = module {
        single { NavigatorGlobal() } binds arrayOf(

        )
    }
}