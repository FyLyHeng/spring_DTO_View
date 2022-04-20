package com.example.springCaches.controller

import com.example.springCaches.model.SaleOrder
import com.example.springCaches.repo.SaleOrderRepository
import com.example.springCaches.repo.TestRepository
import com.example.springCaches.service.SaleOrderEntityTestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityManager
import javax.transaction.Transactional

@RestController
@RequestMapping("/sale-order")
@Transactional
class SaleOrderController {
    @Autowired
    lateinit var saleOrderEntityTestService: SaleOrderEntityTestService

    @Autowired
    lateinit var saleOrderRepository: SaleOrderRepository



    @GetMapping("{id}")
    fun getById(@PathVariable id: Long): SaleOrder? {
        return saleOrderRepository.getById(id)
    }


    @GetMapping("/testRawJpa")
    fun testRawJPA(): MutableList<Any?>? {
        return saleOrderEntityTestService.testRawJPA()
    }

    @GetMapping("/qty/{qty}")
    fun getByQty(@PathVariable qty: Int): List<SaleOrder> {
        val rs = saleOrderRepository.findAllByTotalQty(qty)

        return listOf()
    }


    @PostMapping
    fun addNewSaleOrder(@RequestBody saleOrder: SaleOrder): SaleOrder? {
        return saleOrderEntityTestService.addNew(saleOrder)
    }

    @PutMapping("{id}")
    fun updateSaleOrder(@PathVariable id: Long, @RequestBody saleOrder: SaleOrder): SaleOrder? {
        return saleOrderEntityTestService.updateObj(id, saleOrder)
    }

    @GetMapping("/list")
    fun findAllSaleOrderCriteria(
            @RequestParam(required = false) series: String?,
            @RequestParam page: Int,
            @RequestParam size: Int,
    ): MutableList<SaleOrder>? {
        val saleOrderPage = saleOrderEntityTestService.findFullCriteria(series, page, size)
        return saleOrderPage?.content
    }

    @GetMapping("/all")
    fun findAll (): MutableList<SaleOrder> {
        return saleOrderRepository.findAll().toMutableList()
    }


    lateinit var entityManager : EntityManager
    @GetMapping("/testing")
    fun testRAWNameGraph() : List<SaleOrder?> {

            val entityGraph = entityManager.createEntityGraph(SaleOrder::class.java)
            entityGraph.addAttributeNodes("saleOrderDetail")
            val properties: MutableMap<String, Any> = HashMap()
            properties["javax.persistence.fetchgraph"] = entityGraph

            val rs = entityManager.find(SaleOrder::class.java,1,properties)


        return listOf(rs)
    }
}
