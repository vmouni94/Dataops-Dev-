package com.rsrit.Dops.Server.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("Hello from Api");
		return "Hello From Api";
	}

}