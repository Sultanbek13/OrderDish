package com.sultandev.efftestingapp.navigation

import androidx.navigation.NavController

class NavigatorGlobal {
    private var navController: NavController? = null

    fun bind(navController: NavController) {
        this.navController = navController
    }

    fun unbind() {
        navController = null
    }
}