package com.tcc.iot_mc_api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Leituras")
public class Leitura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private LocalDateTime tempoDaLeitura;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private String unidadeMedida;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    public Leitura() {
    }

    public Leitura(LocalDateTime tempoDaLeitura, double valor, Sensor sensor) {
        this.tempoDaLeitura = tempoDaLeitura;
        this.valor = valor;
        this.sensor = sensor;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getTempoDaLeitura() {
        return tempoDaLeitura;
    }

    public void setTempoDaLeitura(LocalDateTime tempoDaLeitura) {
        this.tempoDaLeitura = tempoDaLeitura;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

}
