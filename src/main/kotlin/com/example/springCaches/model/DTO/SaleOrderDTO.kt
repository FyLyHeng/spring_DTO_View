package com.example.springCaches.model.DTO

import com.example.springCaches.model.BarcodeSale
import com.example.springCaches.model.SaleOrderDetail
import com.fasterxml.jackson.annotation.JsonIdentityReference
import javax.persistence.Id

/**
 * @Noted: this constructor must be the same as target Class constructor
 *
 * cons: the nested domain will duplicate select from DB
 */
//@JsonIdentityReference(alwaysAsId = true)
data class SaleOrderDTO (
        @Id
        var id:Long,
        var totalQty: Int,
        var barcodeSale: BarcodeSale,
//        var saleOrderDetail: MutableList<SaleOrderDetail>

        //not work
//        var barcodeSale: BarcodeSaleDTO? = null,
//        var saleOrderDetail: MutableList<SaleOrderSaleDetailDTO>


) {


        /**
         * Child DTOs custom field
         */
        data class SaleOrderSaleDetailDTO (
                @Id
                var id: Long,
                var qty: Float,
                var amount: Double,
        )

        data class BarcodeSaleDTO (
                @Id
                var id:Long,
//                var barcode:String
        )
}