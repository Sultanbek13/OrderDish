package com.sultandev.feature_category.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.sultandev.feature_category.R
import com.sultandev.feature_category.databinding.ScreenCategoryBinding
import com.sultandev.feature_category.navigation.CategoryNavigation
import com.sultandev.feature_category.presentation.adapter.CategoryAdapter
import com.sultandev.feature_category.presentation.viewmodel.impl.CategoryViewModelImpl
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class CategoryScreen: Fragment(R.layout.screen_category) {

    private val viewModel: CategoryViewModelImpl by viewModel()
    private val adapter by lazy(LazyThreadSafetyMode.NONE) { CategoryAdapter() }
    private val binding: ScreenCategoryBinding by viewBinding()
    private val navigation: CategoryNavigation by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvCategory.adapter = adapter

        viewModel.allCategories.onEach {
            adapter.submitList(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.message.onEach {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.getAllCategories()

        adapter.setOnCategoryListener {
            navigation.openCategoryDetail(it)
        }
    }
}