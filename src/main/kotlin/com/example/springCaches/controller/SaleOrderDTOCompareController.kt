package com.example.springCaches.controller

import com.example.springCaches.model.DTO.*
import com.example.springCaches.model.SaleOrder
import com.example.springCaches.service.SaleOrderService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/sale-order/all")
class SaleOrderDTOCompareController {

    @Autowired
    lateinit var saleOrderService : SaleOrderService



    @GetMapping("/obj-mapping")
    fun allByBOJMapping () : MutableList<OBJMappingDTO>? {
        return saleOrderService.findAllByOBJMapping()
    }


    @GetMapping("/raw-dto")
    fun allByRawDTO (): MutableList<RawDTO> {
        return saleOrderService.findAllByRawDTO()
    }

    @GetMapping("/dto")
    fun getSaleOrderDTO (): List<SaleOrder> {
        return saleOrderService.findAllByDTOClass()
    }


    @GetMapping("/view")
    fun getSaleOrderView (): List<SaleOrder> {
        return saleOrderService.findAllByDTOInterface()
    }

    @GetMapping("/custom-API")
    fun allByCustomAPI (): Page<SaleOrderDTOCustomAPI> {
        return saleOrderService.findAllByUsingCustomAPI()
    }


    @GetMapping("/json-config")
    fun allByJsonCustom (): ObjectMapper {
        return saleOrderService.findAllByJsonConfig()
    }
}