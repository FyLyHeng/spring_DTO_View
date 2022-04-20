package com.example.springCaches.model.DTO


data class RawDTO(
    var totalQty: Int? = 0,
    var grandTotal: Float? = 0f,
    var totalCost: Double? = 0.0,

    //barcode obj we config using by get only barcode.code
    var barcode: String? = ""
)
