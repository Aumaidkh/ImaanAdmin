package com.imaan.imaanadmin.presentation.orders.fragments.delivered

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.imaan.imaanadmin.core.utils.BaseFragment
import com.imaan.imaanadmin.databinding.FragmentDeliveredLayoutBinding
import com.imaan.imaanadmin.presentation.orders.adapters.OrderAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
@AndroidEntryPoint
class FragmentDelivered :BaseFragment<FragmentDeliveredLayoutBinding>(){

   private val viewModel : DeliveredScreenViewModel by viewModels()
    private lateinit var orderAdapter: OrderAdapter
    override fun inflateLayout(inflater: LayoutInflater): FragmentDeliveredLayoutBinding {
        return FragmentDeliveredLayoutBinding.inflate(inflater)
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
        orderAdapter = OrderAdapter{
            ///
        }
        binding.rvDelivered.layoutManager=
            LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        binding.rvDelivered.adapter = orderAdapter
    }

}