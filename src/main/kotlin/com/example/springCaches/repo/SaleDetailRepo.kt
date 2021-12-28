package com.example.springCaches.repo

import com.example.springCaches.model.SaleOrderDetail
import org.springframework.data.jpa.repository.JpaRepository

interface SaleDetailRepo:JpaRepository<SaleOrderDetail,Long> {
}