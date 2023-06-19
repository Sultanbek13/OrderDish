package com.sultandev.feature_main.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.sultandev.feature_main.R
import com.sultandev.feature_main.databinding.ScreenMainBinding
import com.sultandev.feature_main.navigation.NavigatorMain
import org.koin.android.ext.android.inject

internal class MainScreen: Fragment(R.layout.screen_main) {

    private lateinit var navController: NavController
    private val binding: ScreenMainBinding by viewBinding()
    private val navigatorMain: NavigatorMain by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController =
            Navigation.findNavController(requireActivity(), R.id.mainContainer)
        navigatorMain.bind(navController)

        binding.btnNavigation.setupWithNavController(navController)

    }

    override fun onDestroy() {
        super.onDestroy()
        navigatorMain.unbind()
    }
}