package com.halloworld.helo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/hallo")
public class HalloController {

	@GetMapping
	public String hello() {
		return "Hallo Joaquim!!!";

	}
}
