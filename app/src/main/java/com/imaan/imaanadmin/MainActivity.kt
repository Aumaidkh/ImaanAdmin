package com.imaan.imaanadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.imaan.imaanadmin.data.model.order.OrderStatus
import com.imaan.imaanadmin.presentation.orders.adapters.ViewPagerAdapter
import com.imaan.imaanadmin.presentation.orders.fragments.placed.FragmentPlaced
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}