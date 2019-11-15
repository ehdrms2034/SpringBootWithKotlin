package com.example.demo

import sun.jvm.hotspot.tools.jcore.NameFilter

interface CustomerService {
    fun getCustomer(id:Int) : CustomerModel?
    fun createCustomer(customer : CustomerModel)
    fun deleteCustomer(id:Int)
    fun updateCustomer(id:Int, customer: CustomerModel)
    fun searchCustomer(nameFilter: String) : List<CustomerModel>
}