package com.example.demo.model

import javax.persistence.*


@Entity
@Table(name="addresses")
    data class Address(val description:String="",
                       val addressId:Long = 0,
                       val country:String="",
                       val department:String="",
                       val city:String="",
                       val postalCode:Int=0,
                       val streetName:String="",
                       val houseNumber:Int,
                       val customerDni:String="" )
    {
        @Id
        @GeneratedValue
        var addressRegId:Long=0
    }