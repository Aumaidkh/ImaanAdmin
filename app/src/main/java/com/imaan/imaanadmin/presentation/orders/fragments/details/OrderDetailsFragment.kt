package com.imaan.imaanadmin.presentation.orders.fragments.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.imaan.imaanadmin.core.utils.BaseFragment
import com.imaan.imaanadmin.databinding.DashboardViewLayoutBinding
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "OrderDetailsFragment"

@AndroidEntryPoint
class OrderDetailsFragment: BaseFragment<DashboardViewLayoutBinding>() {

   private val args: OrderDetailsFragmentArgs by navArgs()

    override fun inflateLayout(inflater: LayoutInflater): DashboardViewLayoutBinding {
        return DashboardViewLayoutBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val orderId = args.ORDERID

    }
}