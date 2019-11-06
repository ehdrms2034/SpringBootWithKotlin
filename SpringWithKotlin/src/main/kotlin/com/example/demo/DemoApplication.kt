package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@SpringBootApplication
class DemoApplication

@Controller
class FirstConstroller{
	@RequestMapping(value= ["/","/user"], method = arrayOf(RequestMethod.GET))
	@ResponseBody
	fun hello() = "hello World"
}

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
