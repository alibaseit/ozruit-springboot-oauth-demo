package com.ozruit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping(value = "/")
    public String home() {
        return "Hello";
    }

    @GetMapping(value = "/private")
    public String privateZone() {
        return "private zone";
    }
	
	@GetMapping(value="/status")
	public String test() {
		return "Server is up";
	}

}
