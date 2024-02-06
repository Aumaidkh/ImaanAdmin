package com.imaan.imaanadmin.presentation.orders.fragments.shipped

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imaan.imaanadmin.data.model.order.OrderStatus
import com.imaan.imaanadmin.data.repository.order.IOrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShippedScreenViewModel @Inject constructor(
    private val repo : IOrderRepository
): ViewModel(){
    private val _state = MutableStateFlow(ShippedScreenUiState())
    val state get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            loadOrders()
        }
    }

    private suspend fun loadOrders(){
        val shippedOrders = repo.getOrderByStatus(OrderStatus.SHIPPED)
        _state.update {
            it.copy(
                orders = shippedOrders
            )
        }
    }
}