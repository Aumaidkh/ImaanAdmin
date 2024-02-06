package com.imaan.imaanadmin.presentation.orders.fragments.shipped

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.imaan.imaanadmin.core.utils.BaseFragment
import com.imaan.imaanadmin.databinding.FragmentShippedLayoutBinding
import com.imaan.imaanadmin.presentation.orders.adapters.OrderAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class FragmentShipped : BaseFragment<FragmentShippedLayoutBinding>() {

    private val viewModel : ShippedScreenViewModel by viewModels()
    private lateinit var orderAdapter: OrderAdapter
    override fun inflateLayout(inflater: LayoutInflater): FragmentShippedLayoutBinding {
        return FragmentShippedLayoutBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showOrders()
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect{
                orderAdapter.submitOrders(it.orders)
            }
        }
    }

    private fun showOrders(){
        orderAdapter = OrderAdapter()
        binding.rvShipped.layoutManager=
            LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        binding.rvShipped.adapter = orderAdapter
    }

}