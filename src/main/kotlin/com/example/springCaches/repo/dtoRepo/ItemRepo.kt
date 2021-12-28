package com.example.springCaches.repo.dtoRepo

import com.example.springCaches.model.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepo:JpaRepository<Item,Long> {

    fun <T> findAllByItemName(ItemName: String?, type: Class<T>?): T

    /**
     * ContainingIgnoreCase: will convert param and to target find field to the same Case (upper case)
     */
    fun <T> findByItemNameContainingIgnoreCase(ItemName: String?, type: Class<T>?): T

}