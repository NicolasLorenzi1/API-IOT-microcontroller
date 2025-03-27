package com.tcc.iot_mc_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

@GetMapping("hello")
public String HelloWorld() {
    return "Hello World!";
}

}