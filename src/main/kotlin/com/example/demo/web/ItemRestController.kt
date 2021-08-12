package com.example.demo.web

import com.example.demo.bussines.IItemBussiness
import com.example.demo.exceptions.BussinessException
import com.example.demo.exceptions.NotFoundException
import com.example.demo.model.Item
import com.example.demo.utils.Constants
import com.example.demo.utils.RestApiError
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_BASE_ITEMS)
class ItemRestController {
    @Autowired
    val itemBussiness: IItemBussiness? = null

    @GetMapping("")
    fun list(): ResponseEntity<List<Item>>{
        return try {
            ResponseEntity(itemBussiness!!.getItems(), HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/id/{id}")
    fun loadById(@PathVariable("id") idItem:Long):ResponseEntity<Item>{
        return try {
            ResponseEntity(itemBussiness!!.getItemById(idItem), HttpStatus.OK)
        }catch (e: BussinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping("/nombre/{nombre}")
    fun loadByNombre(@PathVariable("nombre") nombreItem:String):ResponseEntity<Item>{
        return try {
            ResponseEntity(itemBussiness!!.getItemByNombre(nombreItem), HttpStatus.OK)
        }catch (e:BussinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e:NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("/addItem")
    fun insert(@RequestBody item: Item):ResponseEntity<Any>{
        return try {
            itemBussiness!!.saveItem(item)
            val responseHeader = HttpHeaders()
            responseHeader.set("location",Constants.URL_BASE_ITEMS+"/"+item.itemId)
            ResponseEntity(item, responseHeader, HttpStatus.CREATED)
        }catch (e:BussinessException){
            //return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
            val apiError = RestApiError(HttpStatus.INTERNAL_SERVER_ERROR,
                "Informacion Enviada no es Valida",
                e.message.toString())
            ResponseEntity(apiError,HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody item: Item):ResponseEntity<Any>{
        return try {
            itemBussiness!!.updateItem(item)
            ResponseEntity(item,HttpStatus.OK)
        }catch (e:BussinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e:NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") idItem: Long):ResponseEntity<Any> {
        return try {
            itemBussiness!!.removeItem(idItem)
            ResponseEntity(HttpStatus.OK)
        } catch (e: BussinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)

        }
    }
}