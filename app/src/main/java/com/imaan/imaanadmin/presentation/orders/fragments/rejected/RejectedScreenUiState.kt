package com.imaan.imaanadmin.presentation.orders.fragments.rejected

import com.imaan.imaanadmin.data.model.order.OrderModel

data class RejectedScreenUiState(
    val loading: Boolean = false,
    val orders: List<OrderModel> = emptyList(),
    val error: String? = null
)
