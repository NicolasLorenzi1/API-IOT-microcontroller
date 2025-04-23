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

    public TesteUsuario updateUsuario(long id, TesteUsuario usuarioNovo) {
        // recebe os dados de existencia do usuario, optional para não dar erro de null value
        Optional<TesteUsuario> usuarioAntigo = usuarioRepository.findById(id);

        if(usuarioAntigo.isPresent()) {
            // altera os dados do usuario
            TesteUsuario usuario = usuarioAntigo.get();
            usuario.setIdade(usuarioNovo.getIdade());
            usuario.setNome(usuarioNovo.getNome());
            return usuario;
        }
        // caso não exista o usuário
        throw new RuntimeException("Usuario not founded in ID: " + id);
    }
}
