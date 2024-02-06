package com.imaan.imaanadmin.presentation.orders.fragments.rejected

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.imaan.imaanadmin.core.utils.BaseFragment
import com.imaan.imaanadmin.databinding.FragmentRejectedLayoutBinding
import com.imaan.imaanadmin.presentation.orders.adapters.OrderAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentRejected : BaseFragment<FragmentRejectedLayoutBinding>() {

    private val viewModel : RejectedScreenViewModel by viewModels()
    private lateinit var ordersAdapter: OrderAdapter
    override fun inflateLayout(inflater: LayoutInflater): FragmentRejectedLayoutBinding {
        return FragmentRejectedLayoutBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showOrders()
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect{
                ordersAdapter.submitOrders(it.orders)
            }
        }
    }

    private fun showOrders(){
        ordersAdapter = OrderAdapter()
        binding.rvRejected.layoutManager=
            LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        binding.rvRejected.adapter = ordersAdapter
    }

}