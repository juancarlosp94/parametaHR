package com.parametaHR.app.service;

import com.parametaHR.app.dto.EmpleadoRequestDTO;
import com.parametaHR.app.dto.EmpleadoResponseDTO;
import com.parametaHR.app.entity.EmpleadoEntity;
import com.parametaHR.app.repository.EmpleadoRepository;
import com.parametaHR.app.soap.EmpleadoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    public EmpleadoResponseDTO calcularDatosEmpleado(EmpleadoRequestDTO empleadoRequest) {

        EmpleadoEntity empleado = new EmpleadoEntity();
        empleado.setNombres(empleadoRequest.getNombres());
        empleado.setApellidos(empleadoRequest.getApellidos());
        empleado.setTipoDocumento(empleadoRequest.getTipoDocumento());
        empleado.setNumeroDocumento(empleadoRequest.getNumeroDocumento());
        empleado.setFechaNacimiento(java.sql.Date.valueOf(empleadoRequest.getFechaNacimiento()));
        empleado.setFechaVinculacion(java.sql.Date.valueOf(empleadoRequest.getFechaVinculacion()));
        empleado.setCargo(empleadoRequest.getCargo());
        empleado.setSalario(empleadoRequest.getSalario());

        empleadoRepository.save(empleado);

        LocalDate today = LocalDate.now();
        Period edad = Period.between(empleadoRequest.getFechaNacimiento(), today);
        Period tiempoVinculacion = Period.between(empleadoRequest.getFechaVinculacion(), today);

        EmpleadoResponse response = (EmpleadoResponse) webServiceTemplate
                .marshalSendAndReceive("http://localhost:8080/ws", empleadoRequest);

        return EmpleadoResponseDTO.builder()
                .nombres(empleadoRequest.getNombres())
                .apellidos(empleadoRequest.getApellidos())
                .tipoDocumento(empleadoRequest.getTipoDocumento())
                .numeroDocumento(empleadoRequest.getNumeroDocumento())
                .edad(edad.getYears() + " años, " + edad.getMonths() + " meses, " + edad.getDays() + " días")
                .tiempoVinculacion(tiempoVinculacion.getYears() + " años, " + tiempoVinculacion.getMonths() + " meses, " + tiempoVinculacion.getDays() + " días")
                .build();
    }
}
