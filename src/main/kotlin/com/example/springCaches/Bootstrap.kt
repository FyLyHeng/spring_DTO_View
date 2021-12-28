package com.example.springCaches

import com.example.springCaches.model.*
import com.example.springCaches.repo.BarcodeSaleRepository
import com.example.springCaches.repo.SaleOrderRepository
import com.example.springCaches.repo.dtoRepo.ItemRepo
import com.example.springCaches.repo.dtoRepo.UomRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.util.*

@Component
class Bootstrap : CommandLineRunner {

    @Autowired
    lateinit var uom : UomRepo

    @Autowired
    lateinit var itemRepo: ItemRepo

    @Autowired
    lateinit var saleOrderRepository: SaleOrderRepository

    @Autowired
    lateinit var barcodeSale: BarcodeSaleRepository


    override fun run(vararg args: String?) {
        initItem()
        initSaleOrder()
    }


    fun initItem() {

        val oum = uom.save(Uom(name = "kg", used = true))

        itemRepo.save(Item(itemName = "item 01",cost = 12.0, uom = oum))
    }

    fun initSaleOrder() {

        val bc = barcodeSale.save(BarcodeSale())

        val sd = SaleOrderDetail(qty = 1f, amount = 100.0, item = Item(id = 1), saleOrder = SaleOrder(id = 1))
        saleOrderRepository.save(SaleOrder(dateDelivery = Date(), totalQty = 1, grandTotal = 100f,totalCost = 100.0, saleOrderDetail = mutableListOf(sd), barcodeSale = bc))
    }
}