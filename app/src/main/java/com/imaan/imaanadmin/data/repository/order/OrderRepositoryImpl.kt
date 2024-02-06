package com.imaan.imaanadmin.data.repository.order

import com.imaan.imaanadmin.data.model.order.OrderModel
import com.imaan.imaanadmin.data.model.order.OrderStatus
import com.imaan.imaanadmin.data.model.order.getDummyOrderItems
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.random.Random

class OrderRepositoryImpl @Inject constructor(): IOrderRepository {

    override suspend fun getAllOrders(): List<OrderModel> {
        delay(4000)
        return getDummyOrders()
    }

    override suspend fun getOrderByStatus(status: OrderStatus): List<OrderModel> {
        return getAllOrders().filter { it.status == status }
    }
}

fun getDummyOrders(count: Int = 10): List<OrderModel>{
    val orders = mutableListOf<OrderModel>()
    repeat(count){
        orders.add(
            OrderModel(
                orderId = it.toString(),
                status = getOrderStatus(),
                address = "Kadapora, Anantnag, J & K, IN, 192101",
                placedAt = (System.currentTimeMillis() + it * 1000L),
                orderItems = getDummyOrderItems(it)
            )
        )
    }
    return orders
}

fun getOrderStatus(): OrderStatus {
    val random = Random.nextInt(5)
    return OrderStatus.values().toList()[random]
}