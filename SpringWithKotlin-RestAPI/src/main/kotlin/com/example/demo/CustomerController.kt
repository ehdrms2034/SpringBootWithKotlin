package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap

@RestController
class CustomerController {

    @Autowired
    private lateinit var customerService: CustomerService

    @RequestMapping(value = ["/customer/{id}"], method = arrayOf(RequestMethod.GET))
    fun getCustomer(@PathVariable id : Int) = customerService.getCustomer(id)

    @RequestMapping(value = ["/customers/"], method = arrayOf(RequestMethod.GET))
    fun getCustomers(@RequestParam(required =  false,defaultValue = "")  nameFilter:String) = customerService.searchCustomer(nameFilter)

    @RequestMapping(value = ["/customer/"],method = arrayOf(RequestMethod.POST))
    fun createCustomer(@RequestBody customer : CustomerModel) = customerService.createCustomer(customer)

    @RequestMapping(value = ["/customer/{id}"],method = arrayOf(RequestMethod.DELETE))
    fun deleteCustomer(@PathVariable id:Int) = customerService.deleteCustomer(id)

    @RequestMapping(value = ["/customer/{id}"],method = arrayOf(RequestMethod.PUT))
    fun updateCustoemr(@PathVariable id:Int, @RequestBody customer: CustomerModel) = customerService.updateCustomer(id,customer)

}
