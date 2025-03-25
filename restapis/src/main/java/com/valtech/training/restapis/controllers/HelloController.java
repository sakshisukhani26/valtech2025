package com.valtech.training.restapis.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//	@RequestMapping(method = RequestMethod.GET,path = "/hello")
	@GetMapping("/hello/{name}")
//	public String hello(@RequestParam("name") String name) {
	public String hello(@PathVariable("name") String name,@RequestParam("times") int times) {
		String result = "";
		for (int i = 0; i < times; i++) {
			result +=name + " ";
			
		}
		return "Hello "+result;
	}
}
