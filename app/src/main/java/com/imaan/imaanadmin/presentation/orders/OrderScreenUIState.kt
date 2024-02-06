package com.imaan.imaanadmin.presentation.orders

import com.imaan.imaanadmin.data.model.order.OrderModel

data class OrderScreenUIState(
    val loading : Boolean = false,
    val error : String? = null,
    val orderItems : List<OrderModel> = emptyList(),
    val pendingOrders : List<OrderModel> = emptyList(),
)
