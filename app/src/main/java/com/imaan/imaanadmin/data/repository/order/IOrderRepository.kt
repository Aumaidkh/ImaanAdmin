package com.imaan.imaanadmin.data.repository.order

import com.imaan.imaanadmin.data.model.order.OrderModel
import com.imaan.imaanadmin.data.model.order.OrderStatus

interface IOrderRepository {

    suspend fun getAllOrders(): List<OrderModel>

    suspend fun getOrderByStatus(status: OrderStatus): List<OrderModel>

    suspend fun getOrderById(orderId: String): OrderModel?


}