package com.example.demo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "transaction")
data class Transaction(val transactionId:Long,
                       val customerDni:Int,
                       val customerMobile:Int,
                       val paymentMethodId:Int,
                       val creditcardNumber:Int,
                       val shopName:String="",
                       val shopId:Int,
                       val shopLocalePhoneNumber:Int,
                       val transactionDate:String="",
                       val transactionTime:String="",
                       val orderId:Int,
                       val totalToPay:Double,
                       val isvType:Double,
                       val isvAmount:Double,
                       val discount:Double,
                       val transactionMsg:String="")
{
    @Id
    @GeneratedValue
    var transactionRegId:Long=0
}