package com.tcc.iot_mc_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.iot_mc_api.model.Leitura;

public interface LeituraRepository extends JpaRepository<Leitura, Long>{
    
}
