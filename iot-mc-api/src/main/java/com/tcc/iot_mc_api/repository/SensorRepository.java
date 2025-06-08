package com.tcc.iot_mc_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.iot_mc_api.model.device.Dispositivo;
import com.tcc.iot_mc_api.model.device.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    
    Optional<Sensor> findByNomeAndDispositivo(String nome, Dispositivo dispositivo); //O método pode retornar um Sensor se encontrar ou retornar um Optional vazio se não encontrar
}
