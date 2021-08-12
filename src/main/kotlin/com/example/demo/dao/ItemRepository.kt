package com.example.demo.dao

import com.example.demo.model.Item
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ItemRepository: JpaRepository<Item,Long> {
    fun findByItemName(name:String): Optional<Item>
}