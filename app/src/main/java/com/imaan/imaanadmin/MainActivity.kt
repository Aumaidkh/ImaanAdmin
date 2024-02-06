package com.imaan.imaanadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.imaan.imaanadmin.data.model.order.OrderStatus
import com.imaan.imaanadmin.presentation.orders.adapters.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_view_layout)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
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
        val viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter
        tabLayoutMediator.attach()

    }
}