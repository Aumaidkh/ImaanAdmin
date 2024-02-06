package com.imaan.imaanadmin.presentation.orders.fragments.placed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.imaan.imaanadmin.core.utils.BaseFragment
import com.imaan.imaanadmin.databinding.FragmentPlacedLayoutBinding
import com.imaan.imaanadmin.presentation.orders.adapters.OrderAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentPlaced : BaseFragment<FragmentPlacedLayoutBinding>(){

   private val viewModel : PlacedScreenViewModel by viewModels()
    private lateinit var orderAdapter : OrderAdapter

    override fun inflateLayout(inflater: LayoutInflater): FragmentPlacedLayoutBinding {
        return FragmentPlacedLayoutBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showOrders()
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect{
                orderAdapter.submitOrders(it.orders)
                binding.progressBar3.visibility =
                    if (it.loading) View.VISIBLE else View.GONE
            }
        }
    }

    private fun showOrders(){
        orderAdapter = OrderAdapter(
            onOrderClicked = {
                Toast.makeText(requireContext(), "Order Clicked: ${it.orderId}", Toast.LENGTH_SHORT).show()
            }
        )
        binding.rvPlacedOrders.layoutManager=
            LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        binding.rvPlacedOrders.adapter = orderAdapter
    }
}