package com.imaan.imaanadmin.presentation.orders.fragments.pending

import com.imaan.imaanadmin.data.model.order.OrderModel

data class PendingScreenUiState(
    val loading: Boolean = false,
    val orders: List<OrderModel> = emptyList(),
    val error: String? = null
)
