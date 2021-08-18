package com.example.demo.bussines

import com.example.demo.model.Transaction


interface iTransactionBusiness {
    fun getTransactions():List<Transaction>
    fun getTransactionById(transactionId: Long): Transaction
    fun getTransactionByCustomerDni(customerDni:Int): Transaction
    fun getTransactionByCustomerMobile(customerMoile:Int):Transaction
    fun getTransactionByShopId(shopId:Int):Transaction
    fun getTransactionByShopName(shopName:String):Transaction
    fun getTransactionByOrderId(orderId:Int):Transaction
    fun saveTransaction(transaction: Transaction): Transaction
    fun saveTransactions(transaction: List<Transaction>):List<Transaction>
    fun removeTransaction(transactionId: Long)
    fun updateTransaction(transaction: Transaction): Transaction
}