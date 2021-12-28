package com.example.springCaches.service

import com.example.springCaches.model.DTO.ItemDTO
import com.example.springCaches.model.DTO.ItemView
import com.example.springCaches.repo.dtoRepo.ItemRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ItemService {

    @Autowired
    lateinit var itemRepo: ItemRepo

    fun getItemByName (itemName:String): ItemDTO {
        return itemRepo.findAllByItemName(itemName,ItemDTO::class.java)
    }

    fun getByName (itemName: String): ItemView {
        return itemRepo.findByItemNameContainingIgnoreCase(itemName,ItemView::class.java)
    }
}