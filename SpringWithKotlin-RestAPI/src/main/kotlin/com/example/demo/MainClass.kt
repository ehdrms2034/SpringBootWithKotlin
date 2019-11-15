package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class MainClass {
    companion object {
        val initialCusotomers = arrayOf(CustomerModel(1, "Kotlin"),
                CustomerModel(2, "hello"),
                CustomerModel(3, "Spring !")
        )
    }

    @Bean
    fun customers() = ConcurrentHashMap<Int, CustomerModel>(
            initialCusotomers.associateBy(CustomerModel::id))
}

fun main(args: Array<String>) {
    runApplication<MainClass>(*args)
}