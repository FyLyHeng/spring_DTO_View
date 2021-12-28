package com.example.springCaches.service

import com.example.springCaches.model.SaleOrder
import com.example.springCaches.repo.SaleOrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.Query
import javax.persistence.criteria.Predicate
import javax.transaction.Transactional

@Service
class SaleOrderDTOTestService {

    @Autowired
    lateinit var saleOrderRepository: SaleOrderRepository
    @Autowired
    lateinit var em:EntityManager

    @Transactional
    fun findById(id: Long): Optional<SaleOrder> {
        return saleOrderRepository.findById(id)
    }

}
