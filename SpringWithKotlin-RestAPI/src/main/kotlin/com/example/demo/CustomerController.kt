package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap

@RestController
class CustomerController {
    @Autowired
    lateinit var customers : ConcurrentHashMap<Int,CustomerModel>

    @RequestMapping(value = ["/customer/{id}"], method = arrayOf(RequestMethod.GET))
    fun getCustomer(@PathVariable id : Int) = customers[id]

    @RequestMapping(value = ["/customers/"], method = arrayOf(RequestMethod.GET))
    fun getCustomers(@RequestParam(required =  false,defaultValue = "")  nameFilter:String) =
            customers.filter {
                it.value.name.contains(nameFilter,true)
            }.map(Map.Entry<Int,CustomerModel>::value).toList()

    @RequestMapping(value = ["/customer/"],method = arrayOf(RequestMethod.POST))
    fun createCustomer(@RequestBody customer : CustomerModel) {
        customers[customer.id] = customer
    }


}
