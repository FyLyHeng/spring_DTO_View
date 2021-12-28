package com.example.springCaches.repo

import com.example.springCaches.model.SaleOrder
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType.*
import org.springframework.data.jpa.repository.Query


@Repository
interface SaleOrderDTORepository : org.springframework.data.repository.Repository<SaleOrder,Long> {

    fun <T> findById(id: Long, type: Class<T>?): T
}
