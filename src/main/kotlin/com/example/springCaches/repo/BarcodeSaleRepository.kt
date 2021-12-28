package com.example.springCaches.repo

import com.example.springCaches.model.BarcodeSale
import com.example.springCaches.model.SaleOrder
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@Repository
interface BarcodeSaleRepository :JpaRepository<BarcodeSale,Long>{
}
