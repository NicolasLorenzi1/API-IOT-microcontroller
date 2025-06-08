package com.tcc.iot_mc_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.iot_mc_api.model.device.Dispositivo;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
    
}
