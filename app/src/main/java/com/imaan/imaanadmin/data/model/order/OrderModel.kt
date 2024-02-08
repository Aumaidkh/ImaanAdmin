package com.imaan.imaanadmin.data.model.order

import com.imaan.imaanadmin.data.model.address.AddressModel
import com.imaan.imaanadmin.data.model.user.UserModel

data class OrderModel(
    val orderId: String,
    val status: OrderStatus,
    val orderItems: List<OrderItem>,
    val address: AddressModel,
    val placedAt: Long,
    val user: UserModel,
    val deliveryCharges: Float,
    val discount: Float
){
    /**
     * Returns the total amount of the order
     * after adding delivery charges and subtracting discount if any
     * */
    val orderTotal get() = run {
        var amount = 0.0f
        orderItems.forEach {
            amount += it.totalAmount
        }
        amount + deliveryCharges - discount
    }
}

enum class OrderStatus (val label : String){
    PENDING("Pending"),
    PLACED("Placed"),
    SHIPPED("Shipped"),
    DELIVERED("Delivered"),
    REJECTED("Rejected")
}
