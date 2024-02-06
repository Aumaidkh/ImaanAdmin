package com.imaan.imaanadmin.presentation.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import com.imaan.imaanadmin.core.utils.BaseFragment
import com.imaan.imaanadmin.data.model.order.OrderStatus
import com.imaan.imaanadmin.databinding.FragmentDashboardLayoutBinding
import com.imaan.imaanadmin.presentation.orders.adapters.ViewPagerAdapter

class FragmentDashboard: BaseFragment<FragmentDashboardLayoutBinding>() {

    override fun inflateLayout(inflater: LayoutInflater): FragmentDashboardLayoutBinding {
        return FragmentDashboardLayoutBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            val tabLayoutMediator = TabLayoutMediator(tabLayout,viewPager){tab, position ->
                if (position == 0){
                    tab.text = OrderStatus.PLACED.label
                }
                else{
                    if (position == 1){
                        tab.text = OrderStatus.SHIPPED.label
                    }
                    else {
                        if (position == 2){
                            tab.text = OrderStatus.REJECTED.label
                        }
                        else {
                            if (position == 3){
                                tab.text = OrderStatus.PENDING.label
                            }
                            else {
                                tab.text = OrderStatus.DELIVERED.label
                            }
                        }
                    }

                }
            }
            val viewPagerAdapter = ViewPagerAdapter(this@FragmentDashboard)
            viewPager.adapter = viewPagerAdapter
            tabLayoutMediator.attach()
        }

    }
}