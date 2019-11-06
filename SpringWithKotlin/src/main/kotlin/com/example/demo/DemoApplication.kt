package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@SpringBootApplication
class DemoApplication

@Controller
class FirstConstroller{
	@Autowired
	lateinit var service : ServiceInterface

	@RequestMapping(value= ["/{name}","/user/{name}"], method = arrayOf(RequestMethod.GET))
	@ResponseBody
	fun hello(@PathVariable name: String) = service.getHello(name)
}

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
