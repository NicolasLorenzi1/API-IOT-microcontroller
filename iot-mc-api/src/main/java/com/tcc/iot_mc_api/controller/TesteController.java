package com.tcc.iot_mc_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.FirebaseApp;

@RestController
public class TesteController {

    @GetMapping("hello")
    public String HelloWorld() {
        return "Hello World!";
    }

    @GetMapping("teste-firebase")
    public String teste() {
        return "Firebase conectado? " + !FirebaseApp.getApps().isEmpty();
    }
}