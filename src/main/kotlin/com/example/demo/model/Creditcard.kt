package com.example.demo.model

import javax.persistence.*

@Entity
@Table(name = "creditcard")
    data class Creditcard(val creditcardNumber:Int,
                          val customerDni:Int,
                          val cvv:Int,
                          val expiration_date:String="",
                          val nametag:String ="")
    {
     @Id
     @GeneratedValue
     var creditcardRegId: Long = 0
    }