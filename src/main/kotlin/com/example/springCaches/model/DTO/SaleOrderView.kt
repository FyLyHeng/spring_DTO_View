package com.example.springCaches.model.DTO


interface SaleOrderView {
    var id: Long
    var totalQty: Int
    var barcodeSale: BarcodeSaleView
    var saleOrderDetail: MutableList<SaleOrderSaleDetailView>




    /**
     * Child DTOs custom field
     */
    interface BarcodeSaleView {
        var barcode : String
    }

    interface SaleOrderSaleDetailView {
        var id: Long
        var qty: Float
        var amount: Double
    }
}