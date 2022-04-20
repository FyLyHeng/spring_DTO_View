package com.example.springCaches.repo

import com.example.springCaches.model.DTO.RawDTO
import com.example.springCaches.model.DTO.SaleOrderView
import com.example.springCaches.model.SaleOrder
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional


@Repository
interface SaleOrderDTORepository : org.springframework.data.repository.Repository<SaleOrder,Long>{

//    @Transactional(readOnly = true)
//    fun <T> findAll(type: Class<T>): MutableList<T>

    //@Transactional(readOnly = true)
    fun findAll () : List<SaleOrder>


    @Query("select s.totalCost as totalCost, s.grandTotal as grandTotal, s.totalQty as totalQty, s.barcodeSale.barcode as barcode from SaleOrder as s")
    fun rawFindAll() : MutableList<RawDTO>


//    @QueryHints(value = [QueryHint(name = org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH, value = "false")])
//    override fun <R : Any?> findAll(p0: Specification<SaleOrder>?, p1: Class<R>?, p2: Pageable?): Page<R>

}
