package com.example.demo

import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class CustomerServiceImpl : CustomerService {

    companion object {
        val initialCusotomers = arrayOf(CustomerModel(1, "Kotlin"),
                CustomerModel(2, "hello"),
                CustomerModel(3, "Spring !")
        )
    }

    val customers = ConcurrentHashMap<Int, CustomerModel>(
            initialCusotomers.associateBy(CustomerModel::id))

    override fun getCustomer(id: Int): CustomerModel? = customers[id]

    override fun createCustomer(customer: CustomerModel) {
        customers[customer.id] = customer
    }

    override fun deleteCustomer(id: Int) {
        customers.remove(id)

    }

    override fun updateCustomer(id: Int, customer: CustomerModel) {
        deleteCustomer(id)
        createCustomer(customer)
    }

    override fun searchCustomer(nameFilter: String): List<CustomerModel> = customers.filter {
        it.value.name.contains(nameFilter,true)
    }.map(Map.Entry<Int,CustomerModel>::value).toList()

}