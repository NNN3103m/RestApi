package com.example.demo.model

import javax.persistence.*

@Entity
@Table(name = "item")
data class Item (val id:Int= 0,
                 val name:String="",
                 val price:Double = 0.0,
                 val photp_url: String="",
                 val category:String="",
                 val shop_id:Int = 0,
                 val is_available:Int = 1,)
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var itemId:Int = 0
}