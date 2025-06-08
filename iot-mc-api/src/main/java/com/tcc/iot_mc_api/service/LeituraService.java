package com.tcc.iot_mc_api.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.tcc.iot_mc_api.dto.LeituraDTO;
import com.tcc.iot_mc_api.model.device.Dispositivo;
import com.tcc.iot_mc_api.model.device.Leitura;
import com.tcc.iot_mc_api.model.device.Sensor;
import com.tcc.iot_mc_api.repository.DispositivoRepository;
import com.tcc.iot_mc_api.repository.LeituraRepository;
import com.tcc.iot_mc_api.repository.SensorRepository;

@Service
public class LeituraService {

    private final DispositivoRepository dispositivoRepository;
    private final SensorRepository sensorRepository;
    private final LeituraRepository leituraRepository;

    public LeituraService(DispositivoRepository dispositivoRepository, SensorRepository sensorRepository, LeituraRepository leituraRepository) {
        this.dispositivoRepository = dispositivoRepository;
        this.sensorRepository = sensorRepository;
        this.leituraRepository = leituraRepository;
    }

    private Dispositivo verificarOuCriarDispositivo(LeituraDTO leituraDTO) {
        return dispositivoRepository.findById(leituraDTO.dispositivoId())
            .orElseGet(() -> {
                Dispositivo novoDispositivo = new Dispositivo();
                novoDispositivo.setNome(leituraDTO.dispositivoNome());
                novoDispositivo.setLocal(leituraDTO.dispositivoLocal());
                return dispositivoRepository.save(novoDispositivo);
            });
    }
    
    private Sensor verificarOuCriarSensor(LeituraDTO leituraDTO, Dispositivo dispositivo) {
        return sensorRepository.findByNomeAndDispositivo(leituraDTO.nomeSensor(), dispositivo)
            .orElseGet(() -> { 
                Sensor novoSensor = new Sensor();
                novoSensor.setNome(leituraDTO.nomeSensor());
                novoSensor.setDispositivo(dispositivo);
                return sensorRepository.save(novoSensor);
            });
    }
    
    private void criarLeitura(LeituraDTO leituraDTO, Sensor sensor) {
        Leitura leitura = new Leitura();
        leitura.setTempoDaLeitura(LocalDateTime.now());
        leitura.setValor(leituraDTO.valor());
        leitura.setSensor(sensor);
        leitura.setUnidadeMedida(leituraDTO.unidadeMedida());
        leituraRepository.save(leitura);
    }

    public void processarLeitura(LeituraDTO leituraDTO) { 
        Dispositivo dispositivo = verificarOuCriarDispositivo(leituraDTO); //verifica se o dispositivo da leitura existe e cria se ele nao existir ainda
        Sensor sensor = verificarOuCriarSensor(leituraDTO, dispositivo);//verifica se o sensor da leitura existe e cria se ele nao existir ainda
        criarLeitura(leituraDTO, sensor);
    }
}