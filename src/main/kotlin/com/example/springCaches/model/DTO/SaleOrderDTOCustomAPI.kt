package com.example.springCaches.model.DTO

import com.example.springCaches.model.Item


interface SaleOrderDTOCustomAPI {
    var id:Long?
    var totalQty: Int?
    var grandTotal: Float?
    var totalCost: Double?
    var barcodeSale: BarcodeDTO?
    var saleOrderDetail : MutableList<SaleOrderDTO.SaleOrderSaleDetailDTO>


    interface BarcodeDTO {
        var barcode : String?
    }

    interface SaleDetailDTO {
        var id:Long?
        var qty: Float?
        var item : Item?
    }
}