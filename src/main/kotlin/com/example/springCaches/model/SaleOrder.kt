package com.example.springCaches.model

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
data class SaleOrder(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = 0,
        var dateDelivery: Date? = null,


        var totalQty: Int? = 0,
        var grandTotal: Float? = 0f,
        var totalCost: Double? = 0.0,


        @OneToOne(fetch = FetchType.LAZY)
        //@JoinColumn(name = "saleOrder")
        var barcodeSale: BarcodeSale? = null,

        //@ElementCollection()
        @OneToMany(mappedBy = "saleOrder", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
        var saleOrderDetail: MutableList<SaleOrderDetail>? = null

)
