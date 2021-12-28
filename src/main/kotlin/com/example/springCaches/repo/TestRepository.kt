package com.example.springCaches.repo

import com.example.springCaches.model.SaleOrder
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@Repository
interface TestRepository :JpaRepository<SaleOrder,Long>{
/*    *//**
     * dynamic
     *//*

    var entityManager : EntityManager

    fun findTest(): SaleOrder?{
        val entityGraph = entityManager.createEntityGraph(SaleOrder::class.java)
        entityGraph.addAttributeNodes("saleOrderDetail")
        val properties: MutableMap<String, Any> = HashMap()
        properties["javax.persistence.fetchgraph"] = entityGraph

        val rs = entityManager.find(SaleOrder::class.java,1,properties)

        return rs
    }
*/
}
