package com.example.springCaches.controller

import com.example.springCaches.model.SaleOrder
import com.example.springCaches.repo.SaleOrderRepository
import com.example.springCaches.service.SaleOrderEntityTestService
import org.hibernate.Version
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/test")
class TestFachController {
    @Autowired
    lateinit var saleOrderRepository: SaleOrderRepository
    @Autowired
    lateinit var saleOrderEntityTestService: SaleOrderEntityTestService



    @GetMapping("/lazy/{id}")
    fun getLazy(@PathVariable id: Long): SaleOrder? {

        val rs = saleOrderRepository.getById(1)

        println("--------")
        println(rs.saleOrderDetail)

        println("--------")
        //println(rs.saleOrderDetail?.get(0)?.invoice)

        return null
    }


    /**
     * testing name entity graph 1 level
     */
    @GetMapping("/entity/{id}")
    fun getNameGraph(@PathVariable id: Long): SaleOrder?  {

        val rs = saleOrderRepository.findById(id)

        println("--------")
        //rs.get().saleOrderDetail//?.get(0)?.amount //saleOrderDetail now is EAGER by config name entity graph

        if (rs.isPresent){
            println("me exist")
        }else{
            println("sorry not exist")
        }
        println("--------")
        //println(rs.get().saleOrderDetail.single().invoice)

        return null
    }



    /**
     * testing name entity graph 2 level
     */
    @GetMapping("/entity-sub/{id}")
    fun getNameGraphSub(@PathVariable id: Long): SaleOrder?  {
        println("Version.getVersionString()  ${Version.getVersionString()}")


        val rs = saleOrderRepository.findAllByTotalQty(2)

        println("--------")
        rs.first().saleOrderDetail //saleOrderDetail now is EAGER by config name entity graph

        println("--------")
        //println(rs.first().saleOrderDetail?.get(0)?.invoice) //invoice now is EAGER by config name entity graph

        return null
    }

    /**
     * testing name entity graph path attribute 1 level
     */
    @GetMapping("/entity-path/{id}")
    fun getNameGraphPathAttribute1(@PathVariable id: Long): SaleOrder?  {

        //val rs = saleOrderRepository.findAllById(id)
        val rs = saleOrderEntityTestService.findById(id)

        println("--------")
        rs.get().saleOrderDetail //saleOrderDetail now is EAGER by config name entity graph

        println("--------")
        //println(rs.first().saleOrderDetail?.get(0)?.invoice) //invoice now is EAGER by config name entity graph

        return null
    }

    /**
     * testing name entity graph path attribute 2 level
     */
    @GetMapping("/entity-path-sub/{id}")
    fun getNameGraphPathAttribute2(@PathVariable id: Long): SaleOrder?  {

        val rs = saleOrderRepository.findAllByTotalCost(20.0)

        println("--------")
        rs.first().saleOrderDetail //saleOrderDetail now is EAGER by config name entity graph

        println("--------")
        //println(rs.first().saleOrderDetail?.get(0)?.invoice) //invoice now is EAGER by config name entity graph

        return null
    }







}
