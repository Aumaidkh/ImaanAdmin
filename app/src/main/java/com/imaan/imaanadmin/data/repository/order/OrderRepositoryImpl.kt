package com.imaan.imaanadmin.data.repository.order

import com.imaan.imaanadmin.data.model.address.dummyAddress
import com.imaan.imaanadmin.data.model.fakeUser
import com.imaan.imaanadmin.data.model.order.OrderModel
import com.imaan.imaanadmin.data.model.order.OrderStatus
import com.imaan.imaanadmin.data.model.order.getDummyOrderItems
import javax.inject.Inject
import kotlin.random.Random

class OrderRepositoryImpl @Inject constructor(): IOrderRepository {

    override suspend fun getAllOrders(): List<OrderModel> {
        return getDummyOrders()
    }

    override suspend fun getOrderByStatus(status: OrderStatus): List<OrderModel> {
        return getAllOrders().filter { it.status == status }
    }

    override suspend fun getOrderById(orderId: String): OrderModel? {
        return getAllOrders().find { it.orderId == orderId }
    }
}

fun getDummyOrders(count: Int = 10): List<OrderModel>{
    val orders = mutableListOf<OrderModel>()
    repeat(count){
        orders.add(
            OrderModel(
                orderId = it.toString(),
                status = getOrderStatus(),
                address = dummyAddress,
                placedAt = (System.currentTimeMillis() + it * 1000L),
                orderItems = getDummyOrderItems(it),
                user = fakeUser,
                deliveryCharges = 40.0f,
                discount = 10.0f
            )
        )
    }
    return orders
}

fun getOrderStatus(): OrderStatus {
    val random = Random.nextInt(5)
    return OrderStatus.values().toList()[random]
}