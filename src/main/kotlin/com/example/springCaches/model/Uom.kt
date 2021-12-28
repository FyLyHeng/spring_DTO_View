package com.example.springCaches.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
class Uom(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = 0,
        @Column(name = "name")
        var name: String? = null,

        @JsonIgnore
        @Column(name = "is_used")
        var used: Boolean? = false
)