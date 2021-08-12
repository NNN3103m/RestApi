package com.example.demo.bussines

import com.example.demo.dao.ItemRepository
import com.example.demo.exceptions.BussinessException
import com.example.demo.exceptions.NotFoundException
import com.example.demo.model.Customer
import com.example.demo.model.Item
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.*

@Service
class ItemBussiness:IItemBussiness {

    @Autowired
    val itemRepository:ItemRepository?=null

    override fun getItems(): List<Item> {
        try {
            return itemRepository!!.findAll();
        }catch (e: Exception){
            throw BussinessException(e.message)
        }
    }

    override fun getItemById(idItem: Long): Item {
        val opt: Optional<Item>
        try {
            opt = itemRepository!!.findById(idItem)
        }catch (e:Exception){
            throw BussinessException(e.message)
        }
        if (!opt.isPresent){
            throw NotFoundException("No se encontro el articulo $idItem")
        }
        return opt.get()
    }

    override fun getItemByNombre(nombreItem: String): Item {
        val opt:Optional<Item>
        try {
            opt = itemRepository!!.findByItemName(nombreItem)
        }catch (e:Exception){
            throw BussinessException(e.message)
        }
        if (!opt.isPresent){
            throw NotFoundException("No se encontro la persona $nombreItem")
        }
        return opt.get()
    }

    override fun saveItem(item: Item): Item {
        try {
            if (item.name.length<5)
                throw BussinessException("Ingrese mas de 5 caracteres")
            return itemRepository!!.save(item)
        }catch (e:Exception){
            throw BussinessException(e.message)
        }
    }

    override fun updateItem(item: Item): Item {
        val opt:Optional<Item>
        try {
            opt = itemRepository!!.findById(item.itemId.toLong())
        }catch (e:Exception){
            throw BussinessException(e.message)
        }
        if (!opt.isPresent){
            throw NotFoundException("No se encontro la persona ${item.itemId}")
        }
        else{
            try {
                return itemRepository!!.save(item)
            }catch (e:Exception){
                throw BussinessException(e.message)
            }
        }
        return opt.get()
    }

    override fun removeItem(idItem: Long) {
        val opt:Optional<Item>
        try {
            opt = itemRepository!!.findById(idItem)
        }catch (e:Exception){
            throw BussinessException(e.message)
        }
        if (!opt.isPresent){
            throw NotFoundException("No se encontro la persona $idItem")
        }
        else{
            try {
                itemRepository!!.deleteById(idItem)
            }catch (e:Exception){
                throw BussinessException(e.message)
            }
        }
    }

}