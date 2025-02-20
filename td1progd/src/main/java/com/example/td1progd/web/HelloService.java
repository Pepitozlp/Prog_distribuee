package com.example.td1progd.web;

import org.springframework.web.bind.annotation.*;


@RestController
public class HelloService {
	@GetMapping("/bonjour")
	public String hello() {
	return "hello";
	}
}
