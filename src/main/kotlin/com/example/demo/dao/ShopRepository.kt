package com.example.demo.dao

import com.example.demo.model.Shop
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ShopRepository: JpaRepository<Shop, Long> {
    fun findByNombre(nombre:String): Optional<Shop>

}