package com.imaan.imaanadmin.data.model.order

data class OrderModel(
    val orderId: String,
    val status: OrderStatus,
    val orderItems: List<OrderItem>,
    val address: String,
    val placedAt: Long,
)

enum class OrderStatus {
    PENDING,
    PLACED,
    SHIPPED,
    DELIVERED,
    REJECTED
}
