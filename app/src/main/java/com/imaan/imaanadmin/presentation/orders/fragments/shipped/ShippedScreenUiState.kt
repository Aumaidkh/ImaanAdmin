package com.imaan.imaanadmin.presentation.orders.fragments.shipped

import com.imaan.imaanadmin.data.model.order.OrderModel

data class ShippedScreenUiState(
    val loading: Boolean = false,
    val orders: List<OrderModel> = emptyList(),
    val error: String? = null
)
