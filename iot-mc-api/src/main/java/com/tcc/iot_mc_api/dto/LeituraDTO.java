package com.tcc.iot_mc_api.dto;

public class LeituraDTO {

    private Long dispositivoId;
    private String dispositivoNome;
    private String dispositivoLocal;
    private String nomeSensor;
    private String unidadeMedida;
    private Double valor;

    public LeituraDTO(Long dispositivoId, String dispositivoNome, String dispositivoLocal, String nomeSensor, String unidadeMedida, Double valor) {
        this.dispositivoId = dispositivoId;
        this.dispositivoNome = dispositivoNome;
        this.dispositivoLocal = dispositivoLocal;
        this.nomeSensor = nomeSensor;
        this.unidadeMedida = unidadeMedida;
        this.valor = valor;
    }

    public Long getDispositivoId() {
        return dispositivoId;
    }

    public void setDispositivoId(Long dispositivoId) {
        this.dispositivoId = dispositivoId;
    }

    public String getNomeSensor() {
        return nomeSensor;
    }

    public void setNomeSensor(String nomeSensor) {
        this.nomeSensor = nomeSensor;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDispositivoNome() {
        return dispositivoNome;
    }

    public void setDispositivoNome(String dispositivoNome) {
        this.dispositivoNome = dispositivoNome;
    }

    public String getDispositivoLocal() {
        return dispositivoLocal;
    }

    public void setDispositivoLocal(String dispositivoLocal) {
        this.dispositivoLocal = dispositivoLocal;
    }
}
