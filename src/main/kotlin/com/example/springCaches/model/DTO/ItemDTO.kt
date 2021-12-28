package com.example.springCaches.model.DTO

import javax.persistence.Id

/**
 * this constructor must be the same as target Class constructor
 */
data class ItemDTO (
        @Id
        var id:Long,
        var itemName:String,
        var cost:Double
)