package com.sultandev.feature_product.presentation

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.sultandev.feature_product.R
import com.sultandev.feature_product.data.model.Product
import com.sultandev.feature_product.databinding.ScreenProductBinding
import com.sultandev.feature_product.navigation.ProductNavigation
import com.sultandev.feature_product.presentation.dialog.ProductDetailDialog
import com.sultandev.feature_product.presentation.adapter.Adapter
import com.sultandev.feature_product.presentation.adapter.ProductItemDelegate
import com.sultandev.feature_product.presentation.adapter.TagItemDelegate
import com.sultandev.feature_product.presentation.viewmodel.impl.ProductViewModelImpl
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class ProductScreen : Fragment(R.layout.screen_product) {

    private val viewModel: ProductViewModelImpl by viewModel()
    private lateinit var tagAdapter: Adapter
    private lateinit var productAdapter: Adapter
    private val binding: ScreenProductBinding by viewBinding()
    private var categoryName: String = ""
    private val navigation: ProductNavigation by inject()
    private var dialog: Dialog? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val delegates = listOf(ProductItemDelegate(), TagItemDelegate())

        tagAdapter = Adapter(delegates)
        binding.rvTag.adapter = tagAdapter

        productAdapter = Adapter(delegates)
        binding.rvProduct.adapter = productAdapter

        arguments?.apply {
            categoryName = getString("category") ?: ""
        }

        binding.categoryDetail.text = categoryName

        setObservers()

        productAdapter.setOnItemClickListener { p ->
            openDetailDialog(p as Product)
        }

        tagAdapter.setOnItemClickListener { t ->
            val tag = t as String
            viewModel.getProductsByTag(tag)
        }

        binding.iconBack.setOnClickListener {
            navigation.onBack()
        }

        viewModel.getAllTags()
        viewModel.getProductsByTag("Все меню")

    }

    private fun openDetailDialog(product: Product) {
        dialog = ProductDetailDialog(requireContext(), product)
        (dialog as ProductDetailDialog).setOnClickAddBasketListener {
            dialog?.dismiss()
            viewModel.onAddBasket(product)
        }
        dialog?.show()
    }

    private fun setObservers() {
        viewModel.allTags.onEach {
            tagAdapter.setItems(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.allProduct.onEach {
            productAdapter.setItems(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.message.onEach {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.addBasket.onEach {
            if (dialog != null) dialog!!.dismiss()
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }
}