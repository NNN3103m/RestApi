package com.example.demo.bussines

import com.example.demo.dao.OrderRepository
import com.example.demo.exceptions.BusinessException
import com.example.demo.exceptions.NotFoundException
import com.example.demo.model.Order
import com.example.demo.model.Seller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.*

@Service
class OrderBusiness:iOrderBusiness {

    @Autowired
    val orderRepository: OrderRepository?=null

    @Throws(BusinessException::class)
    override fun getOrders(): List<Order> {
        try {
            return orderRepository!!.findAll();
        }catch (e: Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun getOrderByOrderId(orderId: Long): Order {
        val opt: Optional<Order>
        try {
            opt = orderRepository!!.findById(orderId)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
        if (!opt.isPresent){
            throw NotFoundException("No se encontro la ordern con referencia $orderId")
        }
        return opt.get()
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun getOrderByCustomerDni(customerDni: Int): Order {
        val opt: Optional<Order>
        try {
            opt = orderRepository!!.findByCustomerDni(customerDni)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
        if (!opt.isPresent){
            throw NotFoundException("No se encontro la ordern con referencia $customerDni")
        }
        return opt.get()
    }

    override fun getOrderByShopId(shopId: Int): Order {
        val opt: Optional<Order>
        try {
            opt = orderRepository!!.findByShopId(shopId)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
        if (!opt.isPresent){
            throw NotFoundException("No se encontro la orden con referencia $shopId")
        }
        return opt.get()
    }

    @Throws(BusinessException::class,NotFoundException::class)
    override fun saveOrder(order: Order): Order {
        try {
            if (order.orderName.length<3)
                throw BusinessException("Ingrese mas de 3 caracteres")
            return orderRepository!!.save(order)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class)
    override fun saveOrders(order: List<Order>): List<Order> {
        try {
            return orderRepository!!.saveAll(order)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class,NotFoundException::class)
    override fun removeOrder(orderId: Long) {
        val opt:Optional<Order>
        try {
            opt = orderRepository!!.findById(orderId)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
        if (!opt.isPresent){
            throw NotFoundException("No se encontro la persona $orderId")
        }
        else{
            try {
                orderRepository!!.deleteById(orderId)
            }catch (e:Exception){
                throw BusinessException(e.message)
            }
        }
    }

    @Throws(BusinessException::class,NotFoundException::class)
    override fun getOrderByOrderName(orderName: String): Order {
        val opt:Optional<Order>
        try {
            opt = orderRepository!!.findByOrderName(orderName)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
        if (!opt.isPresent){
            throw NotFoundException("No se encontro la persona $orderName")
        }
        return opt.get()
    }

    @Throws(BusinessException::class,NotFoundException::class)
    override fun updateOrder(order: Order): Order {
        val opt:Optional<Order>
        try {
            opt = orderRepository!!.findById(order.orderRegId)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
        if (!opt.isPresent){
            throw NotFoundException("No se encontro la persona ${order.orderRegId}")
        }
        else{
            try {
                return orderRepository!!.save(order)
            }catch (e:Exception){
                throw BusinessException(e.message)
            }
        }
        return opt.get()
    }
}