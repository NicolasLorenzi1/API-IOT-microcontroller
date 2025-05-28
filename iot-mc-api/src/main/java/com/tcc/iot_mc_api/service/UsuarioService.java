package com.tcc.iot_mc_api.service;

import org.springframework.stereotype.Service;

import com.tcc.iot_mc_api.dto.UsuarioDTO;
import com.tcc.iot_mc_api.model.Usuario;
import com.tcc.iot_mc_api.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
private final UsuarioRepository usuarioRepository;

public UsuarioService(UsuarioRepository usuarioRepository){
    this.usuarioRepository = usuarioRepository;
}

public void criarUsuario(UsuarioDTO usuarioDTO){
    Usuario usuario = new Usuario(usuarioDTO.getId(),usuarioDTO.getEmail(),usuarioDTO.getSenha()); 
    usuarioRepository.save(usuario);
}
}
