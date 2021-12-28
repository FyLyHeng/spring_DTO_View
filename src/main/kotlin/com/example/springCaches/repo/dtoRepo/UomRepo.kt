package com.example.springCaches.repo.dtoRepo

import com.example.springCaches.model.Uom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UomRepo : JpaRepository<Uom, Long>