package com.example.demo.bussines

import com.example.demo.model.Shop

interface iShopBusiness {
    fun getShops():List<Shop>
    fun getShopById(idShop: Long): Shop
    fun saveShop(shop: Shop): Shop
    fun saveShops(shop: List<Shop>):List<Shop>
    fun removeShop(idShop: Long)
    fun getShopByName(nombreShop: String): Shop
    fun updateShop(shop: Shop): Shop
}