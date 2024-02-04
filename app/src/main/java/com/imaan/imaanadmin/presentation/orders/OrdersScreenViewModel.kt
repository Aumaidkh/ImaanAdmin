package com.imaan.imaanadmin.presentation.orders


import com.imaan.imaanadmin.data.repository.order.IOrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrdersScreenViewModel @Inject constructor(
    private val ordersRepository: IOrderRepository
){

}