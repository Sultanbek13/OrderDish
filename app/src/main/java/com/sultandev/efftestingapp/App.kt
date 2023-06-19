package com.sultandev.efftestingapp

import android.app.Application
import com.sultandev.core_database.di.CoreDatabase
import com.sultandev.core_network.di.CoreNetwork
import com.sultandev.efftestingapp.di.NavigationGlobal
import com.sultandev.feature_basket.di.FeatureBasket
import com.sultandev.feature_main.di.NavigationMain
import com.sultandev.feature_category.di.FeatureCategory
import com.sultandev.feature_product.di.FeatureProduct
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val modules = listOf(CoreNetwork.module, CoreDatabase.module, FeatureCategory.module, FeatureProduct.module, FeatureBasket.module, NavigationGlobal.module, NavigationMain.module)

        startKoin {
            androidLogger()
            androidContext(this@App)
            androidFileProperties()
            koin.loadModules(modules)
        }
    }
}
