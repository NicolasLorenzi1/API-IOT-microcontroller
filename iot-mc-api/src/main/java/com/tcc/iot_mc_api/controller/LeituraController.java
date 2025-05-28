package com.tcc.iot_mc_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.iot_mc_api.dto.LeituraDTO;
import com.tcc.iot_mc_api.dto.UsuarioDTO;
import com.tcc.iot_mc_api.service.LeituraService;
import com.tcc.iot_mc_api.service.UsuarioService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/sensor")
public class LeituraController {

    private final LeituraService leituraService;
    private final UsuarioService usuarioService;

    public LeituraController(LeituraService leituraService, UsuarioService usuarioService) {
        this.leituraService = leituraService;
        this.usuarioService = usuarioService;
    }

    @PostMapping("enviarDados")
    public ResponseEntity<String> receberLeitura(@RequestBody LeituraDTO leituraDTO) {
        leituraService.processarLeitura(leituraDTO);
        return ResponseEntity.ok("valores recebido e salvos");
    }

    @PostMapping("cadastro")
    public ResponseEntity<String> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.criarUsuario(usuarioDTO);
        return ResponseEntity.ok("Usuario cadastrado com sucesso");
    }
    
}
