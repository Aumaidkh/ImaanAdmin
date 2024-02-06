package com.imaan.imaanadmin.presentation.orders.fragments.placed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.imaan.imaanadmin.R
import com.imaan.imaanadmin.core.utils.BaseFragment
import com.imaan.imaanadmin.databinding.FragmentPlacedLayoutBinding
import com.imaan.imaanadmin.presentation.dashboard.FragmentDashboardDirections
import com.imaan.imaanadmin.presentation.orders.adapters.OrderAdapter
import com.imaan.imaanadmin.presentation.orders.fragments.details.OrderDetailsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentPlaced : BaseFragment<FragmentPlacedLayoutBinding>() {

    private lateinit var navController: NavController

    private val viewModel: PlacedScreenViewModel by viewModels()
    private lateinit var orderAdapter: OrderAdapter

    override fun inflateLayout(inflater: LayoutInflater): FragmentPlacedLayoutBinding {
        return FragmentPlacedLayoutBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        showOrders()
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                orderAdapter.submitOrders(it.orders)
                binding.progressBar3.visibility =
                    if (it.loading) View.VISIBLE else View.GONE
            }
        }
    }

    private fun showOrders() {
        orderAdapter = OrderAdapter(
            onOrderClicked = {
//                val bundle = Bundle()
//                bundle.putString("ORDER_ID",it.orderId)
//                navController.navigate(
//                    R.id.action_fragmentDashboard_to_orderDetailsFragment,
//                    bundle
//                )
                val action = FragmentDashboardDirections.actionFragmentDashboardToOrderDetailsFragment(it.orderId)
                navController.navigate(action)
            }
        )
        binding.rvPlacedOrders.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvPlacedOrders.adapter = orderAdapter
    }
}