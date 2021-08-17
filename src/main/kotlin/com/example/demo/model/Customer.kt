package com.example.demo.model

import javax.persistence.*


@Entity
@Table(name = "customer")
    data class Customer (val dni:Long= 0,
                         val mobile:Int,
                         val nombre:String = "",
                         val email: String="",
                         val password:String="")
    {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var customerId:Long = 0
    }