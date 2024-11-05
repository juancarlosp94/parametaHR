package com.parametaHR.app.service;

import com.parametaHR.app.dto.EmpleadoRequestDTO;
import com.parametaHR.app.dto.EmpleadoResponseDTO;
import com.parametaHR.app.entity.EmpleadoEntity;
import com.parametaHR.app.repository.EmpleadoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

//    @Autowired
//    private WebServiceTemplate webServiceTemplate;

    public EmpleadoResponseDTO validarDatosEmpleado(EmpleadoRequestDTO empleadoRequest) {

        EmpleadoRequestDTO empleado = new EmpleadoRequestDTO();
        empleado.setNombres(empleadoRequest.getNombres());
        empleado.setApellidos(empleadoRequest.getApellidos());
        empleado.setTipoDocumento(empleadoRequest.getTipoDocumento());
        empleado.setNumeroDocumento(empleadoRequest.getNumeroDocumento());
        empleado.setFechaNacimiento(empleadoRequest.getFechaNacimiento());
        empleado.setFechaVinculacion(empleadoRequest.getFechaVinculacion());
        empleado.setCargo(empleadoRequest.getCargo());
        empleado.setSalario(empleadoRequest.getSalario());



        if (empleado.getNombres() == null || empleado.getNombres().isEmpty()) {
            throw new ValidationException("El nombre es obligatorio.");
        }
        if (empleado.getApellidos() == null || empleado.getApellidos().isEmpty()) {
            throw new ValidationException("El apellido es obligatorio.");
        }
        if (empleado.getFechaNacimiento() == null) {
            throw new ValidationException("La fecha de nacimiento es obligatoria.");
        }

        LocalDate today = LocalDate.now();
        Period edad = Period.between(empleadoRequest.getFechaNacimiento(), today);
        Period tiempoVinculacion = Period.between(empleadoRequest.getFechaVinculacion(), today);
        int edadAnios = Period.between(empleado.getFechaNacimiento(), today).getYears();

        if (edadAnios < 18) {
            throw new ValidationException("El empleado debe ser mayor de 18 años.");
        }

        EmpleadoEntity empleadoEntity = mapToEntity(empleadoRequest);
        empleadoRepository.save(empleadoEntity);


//        EmpleadoResponse response = (EmpleadoResponse) webServiceTemplate
//                .marshalSendAndReceive("http://localhost:8080/ws", empleadoRequest);

        return EmpleadoResponseDTO.builder()
                .nombres(empleadoRequest.getNombres())
                .apellidos(empleadoRequest.getApellidos())
                .tipoDocumento(empleadoRequest.getTipoDocumento())
                .numeroDocumento(empleadoRequest.getNumeroDocumento())
                .edad(edad.getYears() + " años, " + edad.getMonths() + " meses, " + edad.getDays() + " días")
                .tiempoVinculacion(tiempoVinculacion.getYears() + " años, " + tiempoVinculacion.getMonths() + " meses, " + tiempoVinculacion.getDays() + " días")
                .build();
    }

    private EmpleadoEntity mapToEntity(EmpleadoRequestDTO dto) {
        EmpleadoEntity entity = new EmpleadoEntity();
        entity.setNombres(dto.getNombres());
        entity.setApellidos(dto.getApellidos());
        entity.setTipoDocumento(dto.getTipoDocumento());
        entity.setNumeroDocumento(dto.getNumeroDocumento());
        entity.setFechaNacimiento(java.sql.Date.valueOf(dto.getFechaNacimiento())); // Convert LocalDate to Date
        entity.setFechaVinculacion(java.sql.Date.valueOf(dto.getFechaVinculacion()));
        entity.setCargo(dto.getCargo());
        entity.setSalario(dto.getSalario());
        return entity;
    }
}
