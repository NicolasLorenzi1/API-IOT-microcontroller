package com.tcc.iot_mc_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tcc.iot_mc_api.controller.UsuarioDetails;
import com.tcc.iot_mc_api.dto.UsuarioDTO;
import com.tcc.iot_mc_api.model.Usuario;
import com.tcc.iot_mc_api.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void criarUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario(usuarioDTO.getId(),usuarioDTO.getEmail(),usuarioDTO.getSenha()); 
        usuarioRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return new UsuarioDetails();
    }
}
