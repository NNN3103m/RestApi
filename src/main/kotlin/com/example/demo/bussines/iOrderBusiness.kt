package com.example.demo.bussines

import com.example.demo.model.Order


interface iOrderBusiness {
    fun getOrders():List<Order>
    fun getOrderByOrderId(orderId: Long): Order
    fun getOrderByCustomerDni(customerDni:Int): Order
    fun getOrderByShopId(shopId:Int): Order
    fun saveOrder(order: Order): Order
    fun saveOrders(order: List<Order>):List<Order>
    fun removeOrder(orderId: Long)
    fun getOrderByOrderName(orderName:String): Order
    fun updateOrder(order: Order): Order
}