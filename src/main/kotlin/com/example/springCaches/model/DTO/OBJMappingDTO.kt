package com.example.springCaches.model.DTO

import com.example.springCaches.model.BarcodeSale
import com.example.springCaches.model.SaleOrderDetailMappingDTO

data class OBJMappingDTO (

    var id:Long? =0,
    var totalQty: Int? = 0,
    var grandTotal: Float? = 0f,
    var totalCost: Double? = 0.0,
    //var barcodeSale: BarcodeSale? = null,

    var saleOrderDetail : MutableList<SaleOrderDetailMappingDTO>?= mutableListOf()
)