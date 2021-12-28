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
class SaleOrderEntityTestService {

    @Autowired
    lateinit var saleOrderRepository: SaleOrderRepository
    @Autowired
    lateinit var em:EntityManager

    @Transactional
    fun findById(id: Long): Optional<SaleOrder> {
        return saleOrderRepository.findById(id)
    }

    fun testRawJPA(): MutableList<Any?>? {
        return em.createQuery("select a FROM SaleOrder a").resultList
//        return em.createQuery("update SaleOrder a set a.totalCost = 10 RETURNING a").resultList
    }





    fun findFullCriteria(series: String?, page: Int, size: Int): Page<SaleOrder>? {
        /*return saleOrderRepository.findAll({ root, _, cb ->
            val predicates = ArrayList<Predicate>()

            if (series != null) {
                val saleSeries = cb.like(root.get("series"), "%${series.trim().toUpperCase()}%")
                predicates.add(saleSeries)
            }

            cb.and(*predicates.toTypedArray())
        }, PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id")))*/
        return null
    }


    @Transactional
    fun addNew(t: SaleOrder): SaleOrder? {
        return saleOrderRepository.save(t)
    }

    fun updateObj(id: Long, t: SaleOrder): SaleOrder? {
        val saleOrder = saleOrderRepository.getById(id)

        return saleOrderRepository.save(saleOrder)
    }


    fun findAll(): List<SaleOrder>? {
        return saleOrderRepository.findAll()
    }

}
