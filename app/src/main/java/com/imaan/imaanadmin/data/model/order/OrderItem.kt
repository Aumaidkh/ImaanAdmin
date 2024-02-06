package com.imaan.imaanadmin.data.model.order

import com.imaan.imaanadmin.data.model.product.ProductModel
import java.util.UUID
import kotlin.random.Random

data class OrderItem(
    val product: ProductModel,
    val quantity: Int
){
    val totalAmount get() = quantity * product.price
}

fun Float.toRupees(): String {
    return "₹$this"
}

fun getDummyOrderItems(count: Int): List<OrderItem>{
    val items = mutableListOf<OrderItem>()
    repeat(count){
        items.add(
            OrderItem(
                product = getDummyProduct(),
                quantity = if (it == 0) 1 else it
            )
        )
    }
    return items
}

fun getDummyProduct(): ProductModel {
    val products = mutableListOf(
        ProductModel(
            id = UUID.randomUUID().toString(),
            title = "Sony Camera",
            desc = "Camera features 100 X Zoom",
            imageUrl = "https://images.pexels.com/photos/699122/pexels-photo-699122.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
            price = 100.0f
        ),
        ProductModel(
            id = UUID.randomUUID().toString(),
            title = "Xiaomi Mobile",
            desc = "Camera features 100 X Zoom",
            imageUrl = "https://images.pexels.com/photos/1092644/pexels-photo-1092644.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            price = 12000.0f
        ),
        ProductModel(
            id = UUID.randomUUID().toString(),
            title = "Helicopter",
            desc = "Camera features 100 X Zoom",
            imageUrl = "https://images.pexels.com/photos/87011/helicopter-army-military-war-87011.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            price = 10000000.0f
        ),
        ProductModel(
            id = UUID.randomUUID().toString(),
            title = "Dell Laptop",
            desc = "Camera features 100 X Zoom",
            imageUrl = "https://images.pexels.com/photos/18105/pexels-photo.jpg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            price = 80000.0f
        ),
        ProductModel(
            id = UUID.randomUUID().toString(),
            title = "Apple",
            desc = "Camera features 100 X Zoom",
            imageUrl = "https://images.pexels.com/photos/1630588/pexels-photo-1630588.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            price = 10.0f
        )
    )
    val random = Random.nextInt(products.size)
    return products[random]
}