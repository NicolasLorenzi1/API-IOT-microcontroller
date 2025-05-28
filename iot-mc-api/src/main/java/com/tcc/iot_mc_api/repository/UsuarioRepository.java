package com.tcc.iot_mc_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.iot_mc_api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
