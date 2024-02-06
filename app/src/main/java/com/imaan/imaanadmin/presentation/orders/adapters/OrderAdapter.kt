package com.imaan.imaanadmin.presentation.orders.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.imaan.imaanadmin.R
import com.imaan.imaanadmin.data.model.order.OrderModel
import com.imaan.imaanadmin.data.model.order.OrderStatus
import com.imaan.imaanadmin.data.model.order.OrderStatus.*
import com.imaan.imaanadmin.data.model.order.toRupees
import com.imaan.imaanadmin.databinding.ItemViewLayoutBinding
import java.text.SimpleDateFormat
import java.util.Date

class OrderAdapter(
    private val onOrderClicked: (OrderModel) -> Unit = {}
) : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {
    private var orders = emptyList<OrderModel>()

    fun submitOrders(order: List<OrderModel>) {
        this.orders = order
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemViewLayoutBinding.inflate(layoutInflater, parent, false)
        return OrderViewHolder(binding, onOrderClicked)
    }

    override fun getItemCount(): Int {
        return orders.size
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val orders = orders[position]
        return holder.bind(orders)
    }

    class OrderViewHolder(
        private val binding: ItemViewLayoutBinding,
        private val onOrderClicked: (OrderModel) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(orderModel: OrderModel) {
            with(binding){
                if (orderModel.orderItems.isNotEmpty()) {
                    tvTitle.text = orderModel.orderItems.first().product.title
                    tvAmount.text = orderModel.orderItems.first().totalAmount.toRupees()
                    Glide.with(root.context)
                        .load(orderModel.orderItems.first().product.imageUrl)
                        .into(ivImage)
                }
                tvAdress.text = orderModel.address
                indicator.setBackgroundResource(orderModel.status.toIndicatorColor())
                tvTotalItems.text = orderModel.orderItems.size.toItemQuantity()
                tvDate.text = orderModel.placedAt.toFormattedDateTime()
                tvID.text = "#${orderModel.orderId}"
                root.setOnClickListener {
                    onOrderClicked(orderModel)
                }
            }

        }

        private fun Long.toFormattedDateTime(): String {
            val dateTimeFormatter = SimpleDateFormat("dd/MM/yyyy hh:mm")
            val date = Date(this)
            return dateTimeFormatter.format(date)
        }

        private fun Int.toItemQuantity(): String {
            if (this == 1) {
                return "$this Item"
            }
            return "$this Items"
        }

        private fun OrderStatus.toIndicatorColor(): Int {
            when (this) {
                PENDING -> {
                    return R.color.blue

                }

                PLACED -> {
                    return R.color.blue

                }

                SHIPPED -> {
                    return R.color.blue

                }

                DELIVERED -> {
                    return R.color.blue

                }

                REJECTED -> {
                    return R.color.black

                }
            }
        }
    }

}