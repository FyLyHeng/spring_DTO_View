package com.example.springCaches.repo

import com.example.springCaches.model.SaleOrder
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType.LOAD
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import th.co.geniustree.springdata.jpa.repository.JpaSpecificationExecutorWithProjection
import java.util.*


@Repository
interface SaleOrderRepository : JpaRepository<SaleOrder,Long> , JpaSpecificationExecutorWithProjection<SaleOrder, Long>{

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




    override fun findAll () : List<SaleOrder>

    override fun <R : Any?> findAll(p0: Specification<SaleOrder>?, p1: Class<R>?, p2: Pageable?): Page<R>
}
