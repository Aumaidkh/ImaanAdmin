package com.imaan.imaanadmin.presentation.orders.fragments.placed

import com.imaan.imaanadmin.data.model.order.OrderModel

data class PlacedScreenUiState(
    val loading: Boolean = false,
    val orders: List<OrderModel> = emptyList(),
    val error: String? = null
)
