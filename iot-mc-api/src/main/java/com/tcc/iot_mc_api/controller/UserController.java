package com.tcc.iot_mc_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.iot_mc_api.dto.UserDTO;
import com.tcc.iot_mc_api.model.User;
import com.tcc.iot_mc_api.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService usuarioService;

    public UserController(UserService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("cadastro")
    public ResponseEntity<String> cadastrarUsuario(@RequestBody UserDTO usuarioDTO) {
        usuarioService.criarUsuario(usuarioDTO);
        return ResponseEntity.ok("Usuario cadastrado com sucesso");
    }

    @GetMapping("listar-usuarios")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers() {
        return usuarioService.listarTodosOsUsuarios();
    }

    @DeleteMapping("deletar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.ok("Usuario deletado");
    }
    
}
