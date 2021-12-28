package com.example.springCaches.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
class SaleOrderDetail(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var qty: Float? = 0f,
        var amount: Double? = 0.0,

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "sale_order_id")
        var saleOrder: SaleOrder? = null,


        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "item_id")
        var item: Item? = null,

        @OneToMany(mappedBy = "saleOrderDetail", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
        var invoice: MutableList<Invoice>? = null
)