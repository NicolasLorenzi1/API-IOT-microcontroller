package com.tcc.iot_mc_api.dto;

public record LeituraDTO(Long dispositivoId, String dispositivoNome, String dispositivoLocal, String nomeSensor, String unidadeMedida, Double valor) {
    
    /*
    @Getter
    @Setter
    @AllArgsConstructor

    private Long dispositivoId;
    private String dispositivoNome;
    private String dispositivoLocal;
    private String nomeSensor;
    private String unidadeMedida;
    private Double valor;
    */
}
