package com.tcc.iot_mc_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.FirebaseApp;
import com.tcc.iot_mc_api.dto.TesteValor;
import com.tcc.iot_mc_api.model.TesteUsuario;
import com.tcc.iot_mc_api.repository.TesteUsuarioRepository;

@RestController
@RequestMapping("/api/teste")  
public class TesteController {

    private final TesteUsuarioRepository usuarioRepository;

    public TesteController(TesteUsuarioRepository usuarioRepository) { //injeçao de dependencia
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("hello")
    public String HelloWorld() {
        return "Hello World!";
    }

    @GetMapping("firebase")
    public String teste() {
        return "Firebase conectado? " + !FirebaseApp.getApps().isEmpty();
    }

    @PostMapping("sensor")
    public ResponseEntity<String> receiveData(@RequestBody TesteValor data) {  //uma funçao que converte o corpo da requisição em um objeto java e retorna um resposta
        System.out.println("Valor recebido: " + data.getValor());
        return ResponseEntity.ok("Valor recebido");
    }

    @PostMapping("/usuario")
    public ResponseEntity<String> receberUsuario(@RequestBody TesteUsuario usuario) {
        TesteUsuario usuarioSalvo = usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuário recebido - Nome: " + usuario.getNome() + ", Idade: " + usuario.getIdade() + " " + usuarioSalvo);
    }
}