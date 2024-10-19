package com.parametaHR.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class EmpleadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nombres no puede estar vacío")
    private String nombres;

    @NotBlank(message = "Apellidos no puede estar vacío")
    private String apellidos;

    @NotBlank(message = "Tipo de Documento no puede estar vacío")
    private String tipoDocumento;

    @NotBlank(message = "Número de Documento no puede estar vacío")
    private String numeroDocumento;

    @NotNull(message = "Fecha de Nacimiento no puede estar vacío")
    @Past(message = "La Fecha de Nacimiento debe ser una fecha pasada")
    private Date fechaNacimiento;

    @NotNull(message = "Fecha de Vinculación no puede estar vacío")
    private Date fechaVinculacion;

    @NotBlank(message = "Cargo no puede estar vacío")
    private String cargo;

    @NotNull(message = "Salario no puede estar vacío")
    private Double salario;
}
