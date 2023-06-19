package com.sultandev.efftestingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.sultandev.efftestingapp.navigation.NavigatorGlobal
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private val navigatorGlobal: NavigatorGlobal by inject()

    override fun onResume() {
        super.onResume()
        navigatorGlobal.bind(findNavController(R.id.globalContainer))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.globalContainer) as NavHostFragment
        navController = navHostFragment.findNavController()

    }

    override fun onDestroy() {
        super.onDestroy()
        navigatorGlobal.unbind()
    }
}