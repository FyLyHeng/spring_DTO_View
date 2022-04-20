package com.example.springCaches.model

import com.fasterxml.jackson.annotation.JsonFilter
import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*
import javax.persistence.*
import javax.persistence.CascadeType
import javax.persistence.Entity

/*@NamedEntityGraphs(
        NamedEntityGraph(name = "saleOrder.detail", attributeNodes = [NamedAttributeNode("saleOrderDetail")]),

        NamedEntityGraph(
                name = "saleOrder.detail.invoice",
                attributeNodes = [NamedAttributeNode(value = "saleOrderDetail", subgraph = "map-invoice")],
                subgraphs = [
                        NamedSubgraph(name = "map-invoice", attributeNodes = [NamedAttributeNode("invoice")])
                ]
        )
)*/
@Entity
@JsonFilter("saleOrder")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
data class SaleOrder(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,
    var dateDelivery: Date? = null,


    var totalQty: Int? = 0,
    var grandTotal: Float? = 0f,
    var totalCost: Double? = 0.0,


    @OneToOne(fetch = FetchType.LAZY)
    var barcodeSale: BarcodeSale? = null,


    @OneToMany(
        targetEntity = SaleOrderDetail::class,
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        orphanRemoval = true
    )
    @JoinColumn(name = "sale_order_id", referencedColumnName = "id")
    var saleOrderDetail: MutableList<SaleOrderDetail>? = null,



    @OneToMany(
            targetEntity = Invoice::class,
            cascade = [CascadeType.ALL],
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JoinColumn(name = "sale_invoice_id", referencedColumnName = "id")
    var invoices: MutableList<Invoice>? = null

)
