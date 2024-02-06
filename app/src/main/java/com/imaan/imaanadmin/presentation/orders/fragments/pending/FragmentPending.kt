package com.imaan.imaanadmin.presentation.orders.fragments.pending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.imaan.imaanadmin.core.utils.BaseFragment
import com.imaan.imaanadmin.data.model.order.OrderModel
import com.imaan.imaanadmin.databinding.FragmentPendingLayoutBinding
import com.imaan.imaanadmin.presentation.orders.adapters.OrderAdapter
import com.imaan.imaanadmin.presentation.orders.OrdersScreenViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FragmentPending : BaseFragment<FragmentPendingLayoutBinding>(){
    private val viewModel : PendingScreenViewModel by viewModels()
    private lateinit var orderAdapter: OrderAdapter

    override fun inflateLayout(inflater: LayoutInflater): FragmentPendingLayoutBinding {
        return FragmentPendingLayoutBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showOrders()
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect{
                orderAdapter.submitOrders(it.orders)
                // Show or hide progress bar
                binding.progressBar.visibility = if (it.loading) View.VISIBLE else View.GONE
            }

        }
    }
    private fun showOrders(){
        orderAdapter = OrderAdapter()
        binding.rvPending.layoutManager=
            LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        binding.rvPending.adapter = orderAdapter
    }

}