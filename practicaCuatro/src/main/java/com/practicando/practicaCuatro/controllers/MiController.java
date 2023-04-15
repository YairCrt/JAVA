package com.practicando.practicaCuatro.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Hola")
public class MiController {
	
	@GetMapping	
	public String hola() {
		return "Probando practica 4 version 2";
	}
}
