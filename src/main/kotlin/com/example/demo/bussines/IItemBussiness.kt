package com.example.demo.bussines

import com.example.demo.model.Customer
import com.example.demo.model.Item

interface IItemBussiness {
    fun getItems():List<Item>
    fun getItemById(idItem: Long): Item
    fun getItemByNombre(nombreItem: String): Item
    fun saveItem(item: Item): Item
    fun updateItem(item: Item): Item
    fun removeItem(idItem: Long)

}