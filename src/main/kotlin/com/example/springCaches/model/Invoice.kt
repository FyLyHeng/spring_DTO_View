package com.example.springCaches.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.LazyToOne
import org.hibernate.annotations.LazyToOneOption
import javax.persistence.*

@Entity
class Invoice(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,
    var amount: Double? = 0.0,


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sale_invoice_id", insertable = true, updatable = false, nullable = true)
    var saleOrder: SaleOrder? = null

)
