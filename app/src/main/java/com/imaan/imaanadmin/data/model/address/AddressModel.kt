package com.imaan.imaanadmin.data.model.address

data class AddressModel(
    val id: String,
    val fullname: String,
    val phone: String,
    val fullAddress: String
)

val dummyAddress = AddressModel(
    id = "123",
    fullname = "John Doe",
    phone = "180020802080",
    fullAddress = "Kadapora, Anantnag, J & K, IN, 192101"
)
