package com.example.springCaches.model

import javax.persistence.*

@Entity
class Item(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = 0,
        var itemName: String? = null,
        var cost: Double? = 0.0,


        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "uom_id", nullable = false)
        var uom: Uom ?= null,


        @OneToOne(mappedBy = "item", cascade = [CascadeType.ALL], fetch = FetchType.EAGER,optional = true)
        var barcodeItem: BarcodeItem? = null

)
