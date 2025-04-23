package com.tcc.iot_mc_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.FirebaseApp;
import com.tcc.iot_mc_api.dto.TesteValor;
import com.tcc.iot_mc_api.model.TesteUsuario;
import com.tcc.iot_mc_api.repository.TesteUsuarioRepository;
import com.tcc.iot_mc_api.service.SQLService;

@RestController
@RequestMapping("/api/teste")  
public class TesteController {

    private final TesteUsuarioRepository usuarioRepository;

    @Autowired
    private SQLService sqlService;

    public TesteController(TesteUsuarioRepository usuarioRepository) { //injeçao de dependencia
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("hello")
    public String HelloWorld() {
        return "Hello World!";
    }

    @GetMapping("firebase")
    public String teste() {
        return "Firebase conectado? " + !FirebaseApp.getApps().isEmpty(); // retorna o status da aplicação do firebase
    }

    @PostMapping("sensor")
    public ResponseEntity<String> receiveData(@RequestBody TesteValor data) {  //uma funçao que converte o corpo da requisição em um objeto java e retorna um resposta
        System.out.println("Valor recebido: " + data.getValor());
        return ResponseEntity.ok("Valor recebido");
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<TesteUsuario> putUsuario(@PathVariable long id, @RequestBody TesteUsuario novoUsuario) { // recebe o parametro id enviado no endpoint e o JSON a ser colocado
        TesteUsuario usuario = sqlService.updateUsuario(id, novoUsuario); // manda os parametros para serem utilizados pelo service
        return ResponseEntity.ok(usuario);
    }
    
    @PostMapping("/usuario")
    public ResponseEntity<String> receberUsuario(@RequestBody TesteUsuario usuario) {
        TesteUsuario usuarioSalvo = usuarioRepository.save(usuario); // salva o usuario no Repository, linkando o usuario direto ao servidor
        return ResponseEntity.ok("Usuário recebido - Nome: " + usuario.getNome() + ", Idade: " + usuario.getIdade() + " " + usuarioSalvo);
    }   

}