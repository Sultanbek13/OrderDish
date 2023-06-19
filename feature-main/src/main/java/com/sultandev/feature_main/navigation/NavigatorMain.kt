package com.sultandev.feature_main.navigation

import android.os.Bundle
import androidx.navigation.NavController
import com.sultandev.feature_main.R
import com.sultandev.feature_category.navigation.CategoryNavigation
import com.sultandev.feature_product.navigation.ProductNavigation

class NavigatorMain: CategoryNavigation, ProductNavigation {
    private var navController: NavController? = null

    fun bind(navController: NavController) {
        this.navController = navController
    }

    fun unbind() {
        navController = null
    }

    override fun openCategoryDetail(category: String) {
        val bundle = Bundle()
        bundle.putString("category", category)
        navController?.navigate(R.id.action_categoryScreen_to_productScreen, bundle)
    }

    override fun onBack() {
        navController?.popBackStack()
    }
}