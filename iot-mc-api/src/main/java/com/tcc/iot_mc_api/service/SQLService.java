// SQLService add João
package com.tcc.iot_mc_api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.iot_mc_api.model.TesteUsuario;
import com.tcc.iot_mc_api.repository.TesteUsuarioRepository;

@Service
public class SQLService {
    
    @Autowired
    private TesteUsuarioRepository usuarioRepository; // injeção do repository

    public TesteUsuario updateUsuario(long id, TesteUsuario novoUsuario) {

        TesteUsuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
        usuarioExistente.setNome(novoUsuario.getNome());
        usuarioExistente.setIdade(novoUsuario.getIdade());
        
        return usuarioRepository.save(usuarioExistente); 
    }
}
