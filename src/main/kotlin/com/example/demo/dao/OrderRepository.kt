package com.example.demo.dao

import com.example.demo.model.Order
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface OrderRepository: JpaRepository<Order,Long> {
    fun findByOrderName(orderName:String): Optional<Order>
    fun findByCustomerDni(customerDni: Int): Optional<Order>
    fun findByShopId(shopId: Int): Optional<Order>
}