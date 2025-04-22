package com.tcc.iot_mc_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.FirebaseApp;
import com.tcc.iot_mc_api.dto.TesteValor;

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

    @PostMapping
    public ResponseEntity<String> receiveData(@RequestBody TesteValor data) {  //uma funçao que converte o corpo da requisição em um objeto java e retorna um resposta
        System.out.println("Valor recebido: " + data.getValor());
        return ResponseEntity.ok("Valor recebido");
    }
}