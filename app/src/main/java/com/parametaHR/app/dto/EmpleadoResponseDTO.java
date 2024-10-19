package com.parametaHR.app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpleadoResponseDTO {
    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String numeroDocumento;
    private String edad;
    private String tiempoVinculacion;
}
