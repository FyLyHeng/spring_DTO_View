package com.example.springCaches.controller

import com.example.springCaches.model.DTO.ItemDTO
import com.example.springCaches.model.DTO.ItemView
import com.example.springCaches.model.DTO.SaleOrderDTO
import com.example.springCaches.model.DTO.SaleOrderView
import com.example.springCaches.repo.SaleOrderDTORepository
import com.example.springCaches.service.ItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.transaction.Transactional


@RestController
@RequestMapping("/raw-dto")
@Transactional
class SaleOrderDTOController {
    @Autowired
    lateinit var itemService: ItemService
    @Autowired
    lateinit var saleOrderDTORepository: SaleOrderDTORepository




    @GetMapping("item/dto/{itemName}")
    fun getById(@PathVariable itemName: String): ItemDTO {
        return itemService.getItemByName(itemName)
    }


    @GetMapping("item/view/{itemName}")
    fun getByName(@PathVariable itemName: String): ItemView {
        return itemService.getByName(itemName)
    }


//    @GetMapping("/sale/dto/{id}")
//    fun getSaleOrderDTO (@PathVariable id:Long): SaleOrderDTO {
//        return saleOrderDTORepository.findById(id,SaleOrderDTO::class.java)
//    }


//    @GetMapping("/sale/view/{id}")
//    fun getSaleOrderView (@PathVariable id:Long): SaleOrderView {
//
//        val rs = saleOrderDTORepository.findById(id)
//
//        return rs
//    }
}
