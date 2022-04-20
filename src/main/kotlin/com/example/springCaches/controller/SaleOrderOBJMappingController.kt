package com.example.springCaches.controller

import com.example.springCaches.model.DTO.OBJMappingDTO
import com.example.springCaches.model.DTO.SaleOrderDTO
import com.example.springCaches.model.SaleOrder
import com.example.springCaches.repo.SaleOrderRepository
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors
import javax.transaction.Transactional


@RestController
@RequestMapping("/mapping")
@Transactional
class SaleOrderOBJMappingController {

    @Autowired
    lateinit var modelMapper: ModelMapper

    @Autowired
    lateinit var saleOrderRepository: SaleOrderRepository

    @GetMapping("{id}")
    fun getById(@PathVariable id: Long): SaleOrder? {
        return saleOrderRepository.getById(id)
    }


    @GetMapping("/all")
    fun findAll(): MutableList<OBJMappingDTO>? {
        return saleOrderRepository.findAll().stream().map { saleOrder -> modelMapper.map(saleOrder, OBJMappingDTO::class.java) }
            .collect(Collectors.toList())
    }
}