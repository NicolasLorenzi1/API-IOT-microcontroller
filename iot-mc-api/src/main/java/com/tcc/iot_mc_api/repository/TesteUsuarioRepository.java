package com.tcc.iot_mc_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcc.iot_mc_api.model.TesteUsuario;

@Repository
public interface TesteUsuarioRepository extends JpaRepository<TesteUsuario, Long>{
}
