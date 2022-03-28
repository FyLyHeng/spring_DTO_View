package com.example.springCaches.repo

import com.example.springCaches.model.DTO.SaleOrderView
import com.example.springCaches.model.SaleOrder
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional


@Repository
interface SaleOrderDTORepository : org.springframework.data.repository.Repository<SaleOrder,Long> {

    @Transactional(readOnly = true)
    fun <T> findById(id: Long, type: Class<T>?): T

    @Transactional(readOnly = true)
    fun findById(id: Long): SaleOrderView
}
