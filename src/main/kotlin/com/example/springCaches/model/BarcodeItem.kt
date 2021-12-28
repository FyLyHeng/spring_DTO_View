package com.example.springCaches.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*


@Entity
class BarcodeItem (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?= 0,
    var barcode: String?= null,

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = true)
    var item: Item?= null
)
