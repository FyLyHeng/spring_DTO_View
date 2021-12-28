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


@Repository
interface SaleOrderRepository : JpaRepository<SaleOrder,Long> {

    /**
     * @EntityNameGraph level 1
     * sale - saleDetail
     */
//    @EntityGraph(value = "saleOrder.detail",type = LOAD)
    override fun findById(id: Long): Optional<SaleOrder>


    /**
     * @EntityNameGraph level 2 sub entity graph
     * sale - saleDetail - invoice
     */
    //@EntityGraph(value = "saleOrder.detail.invoice",type = LOAD)
    fun findAllByTotalQty(qty: Int):List<SaleOrder>



    /**
     * @EntityNameGraph attributePaths 1 level
     * saleOrder.saleOrderDetail now is EAGER
     */
    //@EntityGraph(attributePaths = ["saleOrderDetail"],type = LOAD)
    fun findAllById(id: Long):List<SaleOrder>


    /**
     * @EntityNameGraph attributePaths 2 level
     * saleOrder.saleOrderDetail & saleOrderDetail.invoice  now is EAGER
     */
    @EntityGraph(attributePaths = ["saleOrderDetail.invoice.saleOrderDetail"],type = LOAD)
    fun findAllByTotalCost(cost: Double):List<SaleOrder>

}
