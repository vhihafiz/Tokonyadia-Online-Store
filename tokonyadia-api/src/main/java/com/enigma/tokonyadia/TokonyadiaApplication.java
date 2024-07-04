package com.enigma.tokonyadia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class TokonyadiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TokonyadiaApplication.class, args);}



}
