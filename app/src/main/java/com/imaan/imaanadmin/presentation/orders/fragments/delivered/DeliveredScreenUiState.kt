package com.imaan.imaanadmin.presentation.orders.fragments.delivered

import com.imaan.imaanadmin.data.model.order.OrderModel

data class DeliveredScreenUiState(
    val loading: Boolean = false,
    val orders: List<OrderModel> = emptyList(),
    val error: String? = null
)
