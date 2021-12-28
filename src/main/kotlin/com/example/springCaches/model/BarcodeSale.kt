package com.example.springCaches.model

import javax.persistence.*


@Entity
class BarcodeSale (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?= 0,
    var barcode: String = "001*#001"
)
