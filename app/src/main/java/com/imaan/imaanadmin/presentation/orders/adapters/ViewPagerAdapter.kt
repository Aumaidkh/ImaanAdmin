package com.imaan.imaanadmin.presentation.orders.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.imaan.imaanadmin.presentation.orders.fragments.delivered.FragmentDelivered
import com.imaan.imaanadmin.presentation.orders.fragments.pending.FragmentPending
import com.imaan.imaanadmin.presentation.orders.fragments.placed.FragmentPlaced
import com.imaan.imaanadmin.presentation.orders.fragments.rejected.FragmentRejected
import com.imaan.imaanadmin.presentation.orders.fragments.shipped.FragmentShipped

class ViewPagerAdapter (activity: FragmentActivity): FragmentStateAdapter(activity){

    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            FragmentPlaced()
        } else {
          if (position == 1){
              FragmentShipped()
          }
            else {
                if (position == 2){
                    FragmentRejected()
                }
              else {
                  if (position == 3){
                      FragmentPending()
                  }
                    else {
                        FragmentDelivered()
                    }
              }
            }
        }

    }

}