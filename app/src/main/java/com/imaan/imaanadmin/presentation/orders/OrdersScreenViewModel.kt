package com.imaan.imaanadmin.presentation.orders


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
class OrdersScreenViewModel @Inject constructor(
    private val ordersRepository: IOrderRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(OrderScreenUIState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            fetchOrders()
            fetchPendingOrders()
        }
    }

    private suspend fun fetchOrders() {
        _uiState.update {
            it.copy(
                loading = true
            )

        }
        val orders = ordersRepository.getAllOrders()
        _uiState.update {
            it.copy(
                orderItems = ordersRepository.getAllOrders(),
                loading = false
            )

        }
    }

    private suspend fun fetchPendingOrders(){
        _uiState.update {
            it.copy(
                loading = true
            )
        }
        val pendingOrders = ordersRepository.getOrderByStatus(OrderStatus.PENDING)
        _uiState.update {
            it.copy(
                loading = false,
                pendingOrders = pendingOrders
            )
        }
    }

}